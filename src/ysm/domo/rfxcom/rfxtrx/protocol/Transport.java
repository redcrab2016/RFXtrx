/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author edevaux
 *
 */
public class Transport {
	private InputStream in;
	private OutputStream out;
	private MessagePump pump;
	private Thread pumpThread;
	
	class MessagePump implements Runnable {

		private InputStream in;
		private boolean stop;
		private MessageRaw msg;
		private Queue<MessageRaw> msgFIFO; 
		private MessageException pumpException;
		
		MessagePump(InputStream in) {
			this.in  = in;
			stop = false;
			msg = null;
			msgFIFO = new LinkedList<MessageRaw>();
			pumpException = null;
		}
		
		public MessageRaw poll() throws MessageException {
			if (stop && pumpException!= null ) throw pumpException;
			MessageRaw aMsg;
			synchronized (msgFIFO) {
				aMsg = msgFIFO.poll();
			}
			return aMsg;
		}
		
		public void stop() {
			this.stop = true;
		}
		
		public boolean hasMessage() throws MessageException {
			if (stop && pumpException!= null ) throw pumpException;
			boolean hasMsg = false;
			synchronized(msgFIFO) {
				hasMsg = !msgFIFO.isEmpty();
			}
			return hasMsg;
		}
		
		@Override
		public void run() {
			while (! stop) {
				try {
					if (in.available()>0) {
						msg = new MessageRaw(in);
						synchronized(msgFIFO) {
							msgFIFO.add(msg);
						}
					} else {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// don't care
						}
					}
				} catch (MessageException e) {
					pumpException = e;
					stop=true;
				} catch (IOException e) {
					pumpException = new MessageException("Message Pump Exception.",e);
					stop=true;
				}
			}
		}
		
	}
	
	
	
	
	public Transport(InputStream in, OutputStream out) throws TransportException {
		init( in, out );
	}
	
	public Transport(File devicePath) throws TransportException {
		init(devicePath);
	}
	
	public Transport(String devicePath) throws TransportException {
		init(devicePath);
	}
	
	public void sendMessage(MessageRaw msg)  {
		try {
			msg.write(out);
		} catch (MessageException e) {
			new TransportException("Failed to send a message.",e);
		}
	}
	
	public MessageRaw receiveMessage(int timeoutmilli) throws TransportException  {
		return receiveMessage(true,timeoutmilli);
	}
	
	public MessageRaw receiveMessage() throws TransportException  {
		return receiveMessage(true,0);
	}

	public MessageRaw receiveMessage(boolean blocking) throws TransportException  {
		return receiveMessage(blocking,0);
	}
	
	
	
	public MessageRaw receiveMessage(boolean blocking,int timeoutmilli) throws TransportTimeoutException,TransportException  {
		if (!blocking) {
			if (!pendingMessage()) return null;
		}
		try {
			int chunktime=200;
			int countmilli=0;
			while (!pump.hasMessage()) {
				try {
					Thread.sleep(chunktime); // 200 milliseconds wait
				} catch (InterruptedException e) {
					// Don't care ...
				}
				countmilli+=chunktime;
				if (timeoutmilli>0 && countmilli >= timeoutmilli) {
					throw new TransportTimeoutException("Timeout on waiting for message.");
				}
			}
		} catch (MessageException e) {
			throw new TransportException("Failed to message pump status.",e);
		}
		try {
			return pump.poll();
		} catch (MessageException e) {
			throw new TransportException("Failed to poll message pump.",e);
		}
	}
	
	public boolean pendingMessage() throws TransportException {
		try {
			return pump.hasMessage();
		} catch (MessageException e) {
			throw new TransportException("Failed to get pending message status.",e);
		}
	}
	
	public void stop() {
		pump.stop();
	}
	
	public void start() {
		startMessagePump();
	}
	
	@Override
	protected void finalize() throws Throwable {
		stop();
		super.finalize();
	}

	private void init(InputStream in, OutputStream out) throws TransportException {
		if (in == null) throw new TransportException("Null input stream");
		if (out == null) throw new TransportException("Null output stream");
		pump = null;
		pumpThread = null;
		this.in = in;		
		this.out = out;
	}
	
	private void startMessagePump() {
		if (pumpThread != null) {
			pump.stop();
			pump = new MessagePump(in);
			pumpThread = null;
		}

		pump = new MessagePump(in);
		pumpThread = new Thread(pump);
		pumpThread.start();	
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// don't care 
		}
	}
	
	private void init(File devicePath) throws TransportException {
		InputStream in;
		OutputStream out;
		if (devicePath == null)
			throw new TransportException("Null device path File object.");
		if (!devicePath.exists()) 
			throw new TransportException(devicePath.getAbsolutePath() + " doesn't exist");
		if (!devicePath.canRead()) 
			throw new TransportException(devicePath.getAbsolutePath() + " is not readable");
		if (!devicePath.canWrite()) 
			throw new TransportException(devicePath.getAbsolutePath() + " is not writable");
		try {
			in = new FileInputStream(devicePath);
		} catch (FileNotFoundException e) {
			throw new TransportException(devicePath.getAbsolutePath() + " doesn't exist", e);
		}
		try {
			out = new FileOutputStream(devicePath);
		} catch (FileNotFoundException e) {
			try {
				in.close();
			} catch (IOException e1) {
				// don't care we're in clean up context.
			}
			in = null;
			throw new TransportException(devicePath.getAbsolutePath() + " doesn't exist", e);
		}
		init( in, out );
	}
	
	private void init(String devicePath) throws TransportException {
		File fDevicePath = null;
		if ( devicePath == null ) 
			throw new TransportException("Null device path String object.");
		fDevicePath = new File(devicePath);
		init(fDevicePath);
	}
	
	
}
