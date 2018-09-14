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

/**
 * @author edevaux
 *
 */
public class Transport {
	private InputStream in;
	private OutputStream out;
	
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
	
	public MessageRaw receiveMessage() throws TransportException  {
		return receiveMessage(true);
	}
	
	public MessageRaw receiveMessage(boolean blocking) throws TransportException  {
		try {
			if (!blocking) {
				if (!pendingMessage()) return null;
			}
			return new MessageRaw(in);
		} catch (MessageException e) {
			throw new TransportException("Failed to receive a message.",e);
		}
	}
	
	public boolean pendingMessage() throws TransportException {
		try {
			return in.available() != 0;
		} catch (IOException e) {
			throw new TransportException("Failed to evaluate pending message.",e);
		}
	}
	
	
	
	private void init(InputStream in, OutputStream out) throws TransportException {
		if (in == null) throw new TransportException("Null input stream");
		if (out == null) throw new TransportException("Null output stream");
		this.in = in;
		this.out = out;
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
