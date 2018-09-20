/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author edevaux
 *
 */
public class Protocol {

	private static final int TIMEOUT=5000;
	private static final int MAXAGE=10000;
	private Transport transport;
	private Queue<MessageRaw> messageQueue;
	private AtomicInteger controlSequence;
	private AtomicInteger rxtxSequence;
	private RFState RFXStateConfig;
	
	/**
	 * @throws ProtocolException 
	 * 
	 */
	public Protocol(String devicePath) throws ProtocolException {
		try {
			transport = new Transport(devicePath);
			messageQueue = new LinkedList<MessageRaw>();
			controlSequence=new AtomicInteger(0);
			rxtxSequence=new AtomicInteger(0);
		} catch (TransportException e) {
			throw new ProtocolException("Failed to initialize protocol with device '"+String.valueOf(devicePath)+"'",e);
		}
	}
	
	
	public void start() {
		transport.start();
	}
	
	public void stop() {
		transport.stop();
	}
	
	private static void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// do nothing
		}
	
	}
	
	/**
	 * Try to get an already received message by a criteria on type, subtype and sequence number
	 * if a criteria is equal to -1 then the criteria is ignore (accept any value of the criteria)
	 * If a message in the queue is too old then it is removed.
	 * @param type   RF protocol packet type
	 * @param subtype  RF protocol packet subtype
	 * @param sequence RF protocol packet sequence number
	 * @return the Message that match or null otherwise
	 */
	private MessageRaw received(int type, int subtype, int sequence) {
		MessageRaw msg = null;
		synchronized(messageQueue) {
			int size = messageQueue.size();
			for (int i = 0; i< size; i++) {
				msg = messageQueue.poll();
				if ( msg.getAgeMillisecond() > MAXAGE ) continue;
				boolean okType;
				boolean okSubtype;
				boolean okSequence;
				boolean ok;
				okType = (type == -1 || type == msg.getPacketType());
				okSubtype = (subtype == -1 || subtype == msg.getPacketSubtype());
				okSequence = (sequence == -1 || sequence == msg.getSequenceNumber());
				ok = okType && okSubtype && okSequence;
				if ( ok ) {
					return msg;
				}
				messageQueue.add(msg);
			}
		}
		return msg;
	}
	
	private void pump() throws TransportException {
		MessageRaw msg = transport.receiveMessage(false);
		if (msg != null) {
			synchronized (messageQueue) {
				messageQueue.add(msg);
			}
		}
	}
	
	private MessageRaw waitFor(int type, int subtype, int sequence, int timeout) throws ProtocolTimeoutException,ProtocolException {
		MessageRaw msg = null;
		long start = System.currentTimeMillis();
		do {
			try {
				pump();
			} catch (TransportException e) {
				throw new ProtocolException("Failed to pump message.",e);
			}
			msg = received(type, subtype, sequence);
			if (msg == null) {
				pause(100);
			}
			if ( timeout > 0 && ( System.currentTimeMillis() - start ) >= timeout ) {
				throw new ProtocolTimeoutException("Wait timeout Exception (" + timeout + " ms) for message type " + type + ", subtype "+ subtype +", sequence "+sequence );
			}
		} while (msg == null);
		return msg;
	}
	
	
	
	public MessageRaw sendMessageAndWaitFor(int sType, int sSubtype, int sSequence, short[] sData,
											int rType, int rSubtype, int timeout  ) throws ProtocolTimeoutException, ProtocolException, MessageException {
		return sendMessageAndWaitFor(new MessageRaw(sType, sSubtype, sSequence, sData), rType, rSubtype, sSequence, timeout);
	}

	
	public MessageRaw sendMessageAndWaitFor(int sType, int sSubtype, int sSequence, short[] sData,
											int rType, int rSubtype, int rSequence, int timeout  ) throws ProtocolTimeoutException, ProtocolException, MessageException {
		return sendMessageAndWaitFor(new MessageRaw(sType, sSubtype, sSequence, sData), rType, rSubtype, rSequence, timeout);
	}
	
	public MessageRaw sendMessageAndWaitFor(MessageRaw msg, int wType, int wSubtype, int timeout) throws ProtocolTimeoutException, ProtocolException {
		return sendMessageAndWaitFor(msg, wType, wSubtype, msg.getSequenceNumber(),timeout);
	}
	
	
	public MessageRaw sendMessageAndWaitFor(MessageRaw msg, int wType, int wSubtype, int wSequence, int timeout) throws ProtocolTimeoutException, ProtocolException {
		transport.sendMessage(msg);
		return waitFor(wType, wSubtype, wSequence, timeout);
	}
	
	public MessageRaw control(short[] packetData) throws ProtocolTimeoutException, ProtocolException {
		int seq=controlSequence.getAndIncrement()%256;
		MessageRaw msg;
		try {
			msg = new MessageRaw(0,0,seq, packetData);
		} catch (MessageException e) {
			throw new ProtocolException("failed to create message for control",e);
		}
		return sendMessageAndWaitFor(msg, 1,-1,seq,TIMEOUT);
	}
	
	public MessageRaw txRx(int type, int subtype, short[] packetData) throws ProtocolTimeoutException, ProtocolException {
		if (type <4) throw new ProtocolException("Invalid type message "+ type);
		int seq=rxtxSequence.getAndIncrement()%256;
		MessageRaw msg;
		try {
			msg = new MessageRaw(type, subtype, seq, packetData);
		} catch (MessageException e) {
			throw new ProtocolException("failed to create message for control",e);
		}
		return sendMessageAndWaitFor(msg, 2, -1,seq,TIMEOUT);
	}
	
	public String controlReset() throws ProtocolException {
		try {
			MessageRaw msgReset = new MessageRaw(	0/*type*/, 0/*subtype*/, 0/*sequence*/, new short[] {0,0,0,0,0,0,0,0,0,0});
			transport.sendMessage(msgReset);
			// after message reset be sure to clear reception buffer
			for (int i=0;i < 10; i++) { // during 2 secondes consumme the reception
				pause(200);
				transport.receiveMessage(false);
			}
			controlGetStatus();
			return controlStartRFXtrxReceiver();
		} catch (TransportException e) {
			throw new ProtocolException("Device reset failed.",e);
		} catch (MessageException e) {
			throw new ProtocolException("Device reset failed.",e);
		}
		
	}
	
	public RFState getCurrentState() {
		return this.RFXStateConfig;
	}
	
	public RFState controlGetStatus() throws ProtocolTimeoutException, ProtocolException {
		MessageRaw status= control( new short[] {2,0,0,0,0,0,0,0,0,0});
		try {
			this.RFXStateConfig = new RFState(status);
			return new RFState(status) ;
		} catch (MessageException e) {
			throw new ProtocolException("failed to get RF State",e);
		}
	}

	public RFState controlSetMode() throws ProtocolTimeoutException, ProtocolException {
		return controlSetMode(null);
	}
	
	public RFState controlSetMode(RFState rfstate) throws ProtocolTimeoutException, ProtocolException {
		if (rfstate == null) rfstate = this.RFXStateConfig;
		MessageRaw status= control( rfstate.getSetModePacketData());
		try {
			this.RFXStateConfig = new RFState(status);
			return new RFState(status) ;
		} catch (MessageException e) {
			throw new ProtocolException("failed to get RF State",e);
		}
	}
	
	public String controlStartRFXtrxReceiver() throws ProtocolTimeoutException, ProtocolException {
		MessageRaw check= control(new short[] {7,0,0,0,0,0,0,0,0,0});
		short[] packetData = check.getPacketData();
		byte[] byteData = new byte[packetData.length-1];
		for (int i = 1 ; i < packetData.length ; i++) {
			byteData[i-1]=(byte)(packetData[i] & 0xFF);
		}
		String RFXCopyright = new String(byteData);
		if (!"Copyright RFXCOM".equals(RFXCopyright)) {
			throw new ProtocolException("RFX device not ready !");
		}
		return RFXCopyright;
	}
	
}
