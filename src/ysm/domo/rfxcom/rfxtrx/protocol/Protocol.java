//---------------------------------------------------------------------------- 
//                     Software License Agreement                       
//                                                                      
// Copyright 2011-2016, RFXCOM 
// 
// ALL RIGHTS RESERVED. This code is owned by RFXCOM, and is protected under 
// Netherlands Copyright Laws and Treaties and shall be subject to the  
// exclusive jurisdiction of the Netherlands Courts. The information from this 
// file may freely be used to create programs to exclusively interface with 
// RFXCOM products only. Any other use or unauthorized reprint of this material 
// is prohibited. No part of this file may be reproduced or transmitted in 
// any form or by any means, electronic or mechanical, including photocopying, 
// recording, or by any information storage and retrieval system without 
// express written permission from RFXCOM. 
// 
// The above copyright notice shall be included in all copies or substantial 
// portions of this Software. 
//----------------------------------------------------------------------------- 
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ysm.domo.rfxcom.rfxtrx.Config;
import ysm.domo.rfxcom.rfxtrx.io.MessageException;
import ysm.domo.rfxcom.rfxtrx.io.MessageRaw;
import ysm.domo.rfxcom.rfxtrx.io.Transport;
import ysm.domo.rfxcom.rfxtrx.io.TransportException;

/**
 * @author edevaux
 *
 */
public class Protocol {
	private static final Logger LOGGER = Logger.getLogger( Protocol.class.getName() );

	private static final int TIMEOUT=5000;
	private static final int MAXAGE=10000;
	private Transport transport;
	private boolean shutdown;
	private Queue<MessageRaw> messageQueue;
	private AtomicInteger controlSequence;
	private AtomicInteger rxtxSequence;
	private RFState RFXStateConfig;
	private Config config;
	/**
	 * @throws ProtocolException 
	 * 
	 */
	public Protocol(Config config) throws ProtocolException {
		this.config = config;
		init();
	}
	
	/** 
	 * initialize the protocol
	 * @throws ProtocolException
	 */
	public void init() throws ProtocolException {
		LOGGER.info("Service Initializing...");
		transport = null;
		messageQueue = null;
		shutdown = false;
		try {
			start();
		}	catch(ProtocolException e) {
			stop();
			LOGGER.warning("Service initialization failure");
			throw e;
		}
		LOGGER.info("Service Initialized");
	}
	
	/**
	 * Does the Protocol execution is requested to be shut down
	 * @return
	 */
	public boolean shutdown() {
		return shutdown;
	}
	
	public void start() throws ProtocolException {
		if (transport != null) {
			stop();
		}
		try {
			transport = new Transport(config);
			messageQueue = new LinkedList<MessageRaw>();
			controlSequence=new AtomicInteger(0);
			rxtxSequence=new AtomicInteger(0);		
			transport.start();
			controlReset();
		} catch(TransportException e) {
			if (transport != null) transport.stop();
			throw new ProtocolException("Failed to initialize protocol with device.",e);			
		}
	}
	
	/**
	 * Stop the transport execution
	 */
	public void stop() {
		if (transport == null) return;
		transport.stop();
		pause(1000);
		transport = null;
	}
	
	/**
	 * Do a Thread sleep
	 * @param milliseconds
	 */
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
	
	public MessageRaw waitFor(int type, int subtype, int sequence, int timeout) throws ProtocolTimeoutException,ProtocolException {
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
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// do nothing
		}

		return sendMessageAndWaitFor(msg, 1,-1,seq,TIMEOUT);
	}
	
	public MessageRaw transmit(String strMessage) throws ProtocolTimeoutException, ProtocolException {
		if (	strMessage == null ||
				strMessage.trim().length() == 0 ||
				strMessage.indexOf('(')==-1) {
			LOGGER.info("Ignoring message '" + String.valueOf(strMessage) + "'");
			return null;
		}
		LOGGER.info("Send message : " + strMessage);
		ScriptEngineManager engineManager =	new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("javascript");
		try {
			// eval base script for message generation
			String scriptName = "ysm/domo/rfxcom/rfxtrx/protocol/generateMessage.js";
			InputStream inScript = Thread.currentThread().getContextClassLoader().getResourceAsStream(scriptName);
			InputStreamReader inreader=new InputStreamReader(inScript);
			JSMessageBean msgBean= new JSMessageBean();
			engine.put("msg", msgBean);
			engine.put(ScriptEngine.FILENAME, scriptName);
			engine.eval(inreader);
			inreader.close();
			// eval script given by configuration (extension)
			String strScriptExtensionPath = config.get("rfxtrx.protocol.script.generatemessage.path");
			if (strScriptExtensionPath != null ) {
				File script= new File(strScriptExtensionPath);
				if (script.exists() && script.isFile() && script.canRead()) {
					inreader = new InputStreamReader(new FileInputStream(script));
					engine.put(ScriptEngine.FILENAME, strScriptExtensionPath);
					engine.eval(inreader);
					inreader.close();
				} else {
					LOGGER.warning("Can't access for execution javascript file '"+strScriptExtensionPath+"'");
				}
			}
			// eval the message
			 engine.put(ScriptEngine.FILENAME, "InputMessage");
			 engine.eval(strMessage);
			 return transmit(msgBean.getType(), msgBean.getSubtype(), msgBean.getData());
			
			
		} catch (ScriptException | IOException e) {
			LOGGER.log(Level.SEVERE,"Failed to evaluate Incomming message'" + strMessage + "' to transmit",e);
		}
			
		return null;
	}

	public MessageRaw transmit(int type, int subtype, short[] packetData) throws ProtocolTimeoutException, ProtocolException {
		if (type <4) throw new ProtocolException("Invalid type message "+ type);
		int seq=rxtxSequence.getAndIncrement()%256;
		MessageRaw msg;
		try {
			msg = new MessageRaw(type, subtype, seq, packetData);
		} catch (MessageException e) {
			throw new ProtocolException("failed to create message for control",e);
		}
		LOGGER.info("Send message : " + msg.toString());
		return sendMessageAndWaitFor(msg, 2, -1,seq,TIMEOUT);
	}
	
	public String controlReset() throws ProtocolException {
		try {
			LOGGER.info("Start transceiver reset procedure");
			MessageRaw msgReset = new MessageRaw(	0/*type*/, 0/*subtype*/, 0/*sequence*/, new short[] {0,0,0,0,0,0,0,0,0,0});
			transport.sendMessage(msgReset);
			LOGGER.info("Reset message sent");
			// after message reset be sure to clear reception buffer
			for (int i=0;i < 10; i++) { // during 2 secondes consumme the reception
				pause(200);
				transport.receiveMessage(false);
			}
			LOGGER.info("Transceiver pending reading cleared");
			LOGGER.info("Transceiver status requested");
			controlGetStatus();
			LOGGER.info("Transceiver status received");
			String strfrequency=RFXStateConfig.getRfFrequency().getDescription();
			if (config.getKeyList().contains("rfxtrx.protocol.frequency")) {
				strfrequency= config.get("rfxtrx.protocol.frequency");
			} 
			String strxmitpower= RFXStateConfig.getXmitPower().getDescription() ;
			if (config.getKeyList().contains("rfxtrx.protocol.frequency")) {
				strxmitpower= config.get("rfxtrx.protocol.txpower");
			} 
			String strproto = config.get("rfxtrx.protocol.enable");
			boolean toUpdate = false;
			if (strproto != null) {
				String[] protoArray = strproto.split(",");
				RFXStateConfig.disableAllProtocol();
				for (String proto: protoArray) {
					if (RFXStateConfig.enableProtocol(proto.trim()))
						toUpdate = true;
				}
			}
			if (strxmitpower != null) {
				RFxmitpwr txpower = RFxmitpwr.get(strxmitpower);
				if (txpower != null &&
					RFXStateConfig.getRfxtrxType().getModel().isXmitpwr() &&
					txpower != RFXStateConfig.getXmitPower()) {
					RFXStateConfig.setXmitPower(txpower);
					toUpdate = true;
				}
			}
			if (strfrequency != null) {
				RFfrequency freq = RFfrequency.get(RFXStateConfig.getRfxtrxType().getModel(), strfrequency);
				if (freq != null && freq != RFXStateConfig.getRfFrequency()) {
					RFXStateConfig.setRfFrequency(freq);
					toUpdate = true;
				}
			}
			if (toUpdate) {
				controlSetMode();
				LOGGER.info("Transceiver mode set");
			}
			String started =  controlStartRFXtrxReceiver();
			LOGGER.info("\nDevice License    : "+started + "\n" + RFXStateConfig.toString());
			return started;
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
	
	/**
	 * Service main function
	 * Read message to transmit in the air from a named pipe
	 * Execute a process from message received from RFXTrx device
	 * @throws ProtocolException
	 */
	public void loopInOut() throws ProtocolException {
		MessageRaw msg = null;
		// if needed , create the named pipe to be used for message sending
		String pipeInName = config.get("rfxtrx.protocol.input.path");
		if (pipeInName == null || pipeInName.trim().length() == 0) {
			throw new ProtocolException("Missing or empty key rfxtrx.protocol.input.path in configuration");
		}
		File pipeInFile = new File(pipeInName);
		if (!pipeInFile.exists()) {
			String pipeInCmd = config.get("rfxtrx.protocol.input.path.configcommand");
			if (pipeInCmd == null || pipeInCmd.trim().length()==0) {
				throw new ProtocolException("Missing or empty key rfxtrx.protocol.input.path.configcommand in configuration");
			}
			try {
				Process  pipeCmdProc = Runtime.getRuntime().exec(pipeInCmd);
				try {
					int status = pipeCmdProc.waitFor();
				} catch (InterruptedException e) {
					// do nothing
				}
			} catch (IOException e) {
				throw new ProtocolException("Failed to execute '"+pipeInCmd+"'",e);
			}
		}
		
		
		InputStream in = null;
		byte[] buffer = new byte[64000];
		int bufflen = 0;
		do { // loop between message to send and message to receive
			if (transport.isStopped()) break; // transport must be running
			// process Input (transmit message in the Air)
			// read the named pipe, and interpret it 
			// to generate the message to send 
			if (in == null) {
				try {
					try {
						String [] bootPipe= {"sh","-c", "echo '' >"+pipeInName};
						Runtime.getRuntime().exec(bootPipe);
					} catch (IOException e) {
						LOGGER.log(Level.SEVERE,"can't bootstarp the pipe !",e);
					}
					in = new FileInputStream(pipeInFile);
				} catch (FileNotFoundException e) {
					throw new ProtocolException("Can't read "+pipeInName,e);
				}
			}
			
			try {
				while (in != null && in.available()>0) {
					int c = in.read();
					if (c==13 || c==10) {
						byte[] forString = new byte[bufflen];
						for (int i=0; i < bufflen; i++) {
							forString[i] = buffer[i];
						}
						String strMessage = new String( forString);
						if (strMessage.equalsIgnoreCase(config.get("rfxtrx.protocol.input.stopcommand","servicestop"))) {
							transport.stop();
							shutdown = true;
						} else {
							this.transmit(strMessage);
						}
						bufflen=0;
						break;
					} else {
						if (c>=0)
							buffer[bufflen++] = (byte)(c & 0xFF);
					}
				}
			} catch (IOException e1) {
				//don't care .. retry later
				in = null;
			}
			
			// process output (Received message)
			// by the received message, execute a process
			try {
				msg = this.waitFor(-1, -1, -1, 1);
				LOGGER.info("received message : " + msg.toString());
				int ptype = msg.getPacketType();
				int psubtype = msg.getPacketSubtype();
				String strTypeSubtype = MessageRaw.toHexaByte(ptype)+"."+MessageRaw.toHexaByte(psubtype);
				String rootKey="rfxtrx.protocol.event.";
				String eventCmd = config.get(rootKey+strTypeSubtype,
									config.get(rootKey+"default"));
				if (eventCmd == null) {
					LOGGER.log(Level.SEVERE, "No command configuration for type.subtype "+strTypeSubtype);
				}
				// invoke event program for the message
				this.executeMessage(msg, eventCmd);
			} catch (ProtocolTimeoutException e) {
				
				// do nothing retry to wait 
			} catch (ProtocolException e) {
				throw e;
			}
			
		} while(true);
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				LOGGER.warning("Failed to close input named pipe:"+e.getMessage());
				// don't care
			}
	}
	
	
	private void executeMessage(MessageRaw msg, String cmd) {
		try {
			//new ProcessBuilder(eventCmd).start();
			String [] env = getEnv(msg);
			Process p = Runtime.getRuntime().exec(cmd,env);
			LOGGER.info("Execute :"+cmd);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to start '"+cmd+"'", e);
		}
	}
	
	private String [] getEnv(MessageRaw msg) {
		String [] result = null;
		Map<String,String> parentEnv = System.getenv();
		Map<String,String> curEnv = new HashMap<String,String>();
		for (Entry<String,String> parentEntry : parentEnv.entrySet()) {
			curEnv.put(String.valueOf(parentEntry.getKey()), String.valueOf(parentEntry.getValue()));
		}
		// Add specific env variable
		addMessageInfo(msg, curEnv);
		// transform map into array of String as key=value 
		result = new String[curEnv.size()];
		int i=0;
		for (Entry<String,String> curEntry : curEnv.entrySet()) {
			result[i++]=String.valueOf(curEntry.getKey()) + "=" + String.valueOf(curEntry.getValue());
		}
		return result;
	}
	
	private void addMessageInfo(MessageRaw msg, Map<String,String> env) {
		String prefix = config.get("rfxtrx.protocol.event.environementvariable.prefix","RFXCOM_");
		env.put(prefix+"PACKET_HEXA",msg.toHexa());
		env.put(prefix+"PACKET_LENGTH", String.valueOf(msg.getPacketLength()));
		env.put(prefix+"PACKET_TYPE", String.valueOf(msg.getPacketType()));
		env.put(prefix+"PACKET_SUBTYPE", String.valueOf(msg.getPacketSubtype()));
		env.put(prefix+"PACKET_SEQUENCENUMBER", String.valueOf(msg.getSequenceNumber()));
		short[] packetData = msg.getPacketData();
		env.put(prefix+"PACKET_DATA_LENGTH", String.valueOf(packetData.length));
		for (int i = 0 ; i< packetData.length ; i++) {
			env.put(prefix+"PACKET_DATA"+i, String.valueOf(packetData[i]));
		}
		RFmsgSubtype subtype = RFmsgSubtype.get(msg.getPacketType(), msg.getPacketSubtype());
		Map<String,Object> interpret = msg.getSecondLevelInterpret();
		for (Entry<String,Object> entry : interpret.entrySet()) {
			env.put(prefix + "MSG_" + /*subtype.toString()+"_"+ */ entry.getKey(), entry.getValue().toString());
		}
		if (subtype != null) {
			env.put(prefix+"TYPE_NAME", subtype.getMsgType().toString());
			env.put(prefix+"SUBTYPE_NAME", subtype.toString());
			env.put(prefix+"TYPE_DESC", subtype.getMsgType().getDescription());
			env.put(prefix+"SUBTYPE_DESC", subtype.getDescription());
		}
	}
	
}
