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
package ysm.domo.rfxcom.rfxtrx.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import ysm.domo.rfxcom.rfxtrx.protocol.RFmsgSubtype;

/**
 * @author edevaux
 * RFXtrx raw message class
 */
public class MessageRaw {

	private final static int PACKET_LENGTH = 0;
	private final static int PACKET_TYPE = 1;
	private final static int PACKET_SUBTYPE = 2;
	private final static int SEQUENCE_NUMBER = 3;
	private final static int PACKET_DATA = 4;
    private long createtime;
	private short[] content;

	public MessageRaw() {
		init();
	}

	public MessageRaw(InputStream in) throws MessageException {
		this(stream2MessageRaw(in));
	}

	public MessageRaw(int packetType, int packetSubtype, int sequenceNumber, short[] packetData)
			throws MessageException {
		this();
		setPacketType(packetType);
		setPacketSubtype(packetSubtype);
		setSequenceNumber(sequenceNumber);
		setPacketData(packetData);
	}

	public MessageRaw(MessageRaw mr) throws MessageException {
		this();
		setPacket(mr.content);
	}

	public Map<String,Object> getFirstLevelInterpret() {
		RFmsgSubtype subtype = RFmsgSubtype.get(getPacketType(), getPacketSubtype());
		Map<String,Object> result = new HashMap<String,Object>();
		if (subtype != null) {
			String [] mapping = subtype.getMapping();
			int index=PACKET_DATA;
			for (String key : mapping) {
				if (index >=content.length) break;
				short value = content[index];
				result.put(key, value);
				index++;
			}
		}
		return result;
	}
	
	public MessageRaw(short[] packet) throws MessageException {
		this();
		setPacket(packet);
	}
	
	public long getCreationTime() {
		return createtime;
	}
	
	public long getAgeMillisecond() {
		return System.currentTimeMillis()-createtime;
	}

	public short[] getPacket() {
		int size = getPacketLength() + 1;
		short[] packet = new short[size];
		for (int i = 0; i < size; i++) {
			packet[i] = content[i];
		}
		return packet;
	}

	public short[] getPacketData() {
		int size = getPacketLength() - 3;
		short[] packetData = new short[size];
		for (int i = 0; i < size; i++) {
			packetData[i] = content[i + PACKET_DATA];
		}
		return packetData;
	}
	
	public short getPacketData(int i) throws MessageException {
		try {
			if (i <0) throw new MessageException("Index data can't be negative ("+i+").");
			return  content[i + PACKET_DATA];
		} catch (IndexOutOfBoundsException e) {
			throw new MessageException("To high data index .",e);
		}
	}

	public int getPacketLength() {
		return (int) content[PACKET_LENGTH];
	}

	public short[] getPacketRaw() {
		short[] packetRaw = new short[getPacketLength() + 1];
		for (int i = 0; i < packetRaw.length; i++) {
			packetRaw[i] = content[i];
		}
		return packetRaw;
	}

	public int getPacketSubtype() {
		return (int) content[PACKET_SUBTYPE];
	}

	public int getPacketType() {
		return (int) content[PACKET_TYPE];
	}

	public int getSequenceNumber() {
		return (int) content[SEQUENCE_NUMBER];
	}

	public void setPacket(InputStream in) throws MessageException {
		setPacket(stream2packet(in));
	}

	public void setPacket(short[] packet) throws MessageException {
		validatePacket(packet);
		int size = packet[PACKET_LENGTH];
		for (int i = 0; i < size + 1; i++) {
			content[i] = packet[i];
		}
		createtime=System.currentTimeMillis();
	
	}

	public void setPacketData(short[] packetData) throws MessageException {
		if (packetData == null)
			throw new MessageException("Null data packet");
		if (packetData.length == 0)
			throw new MessageException("Empty data packet");
		if (packetData.length > 255 - 3)
			throw new MessageException("Too large data packet (max 252, current length is  " + packetData.length + ")");
		setPacketLength(packetData.length + 3);
		for (int i = 0; i < packetData.length; i++) {
			content[i + PACKET_DATA] = packetData[i];
		}
	}

	public void setPacketSubtype(int packetSubtype) {
		content[PACKET_SUBTYPE] = (short) (packetSubtype & 0xFF);
	}

	public void setPacketType(int packetType) {
		content[PACKET_TYPE] = (short) (packetType & 0xFF);
	}

	public void setSequenceNumber(int sequenceNumber) {
		content[SEQUENCE_NUMBER] = (short) (sequenceNumber & 0xFF);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getStringByte("PacketLength", getPacketLength()));
		sb.append(getStringByte("PacketType", getPacketType()));
		sb.append(getStringByte("PacketSubtype", getPacketSubtype()));
		sb.append(getStringByte("SequenceNumber", getSequenceNumber()));
		sb.append(getStringByte("PacketData", getPacketData()));
		return sb.toString();
	}

	public void write(OutputStream out) throws MessageException {
		packet2stream(this, out);
	}

	private static String getStringByte(String label, int value) {
		return label + "=(0x" + toHexaByte(value) + ") ";
	}

	private static String getStringByte(String label, short[] values) {
		StringBuffer sb = new StringBuffer();
		sb.append(label);
		sb.append("=(");
		for (int i = 0; i < values.length; i++) {
			sb.append("0x");
			sb.append(toHexaByte(values[i]));
			if (i < values.length - 1)
				sb.append(",");
		}
		sb.append(") ");
		return sb.toString();
	}

	private void init() {
		content = new short[256];
		for (int i = 0; i < content.length; i++) {
			content[i] = 0;
		}
		createtime=System.currentTimeMillis();
	}

	private void setPacketLength(int packetLength) {
		content[PACKET_LENGTH] = (short) (packetLength & 0xFF);
	}

	public static String toHexaByte(int value) {
		String result = Integer.toHexString(value & 0xff);
		if (result.length() == 1) {
			result = "0" + result;
		}
		result = result.toUpperCase();
		return result;
	}

	public static void packet2stream(MessageRaw mr, OutputStream out) throws MessageException {
		packet2stream(mr.content, out);
	}

	public static void packet2stream(short[] packet, OutputStream out) throws MessageException {
		validatePacket(packet);
		int size = packet[PACKET_LENGTH];
		byte[] bpacket = new byte[size + 1];
		for (int i = 0; i < size + 1; i++) {
			bpacket[i] = (byte) (packet[i] & 0xff);
		}
		try {
			synchronized(out) {
				//for (int i = 0; i < size + 1; i++) {
				//	System.out.println("--byte out "+i+" :"+((0xffff & bpacket[i])&0x00ff));
				//}
				out.write(bpacket, 0, size + 1);
				out.flush();
			}
		} catch (IOException e) {
			throw new MessageException("Failed to write packet into a stream.", e);
		}
	}

	public static MessageRaw stream2MessageRaw(InputStream in) throws MessageException {
		short[] packet = stream2packet(in);
		return new MessageRaw(packet);
	}

	public static short[] stream2packet(InputStream in) throws MessageException {
		short[] packet = null;
		byte[] bpacket = null;
		int size;
		try {
			size = in.read();
		} catch (IOException e) {
			throw new MessageException("Error while reading stream for packet length field.", e);
		}
		if (size == -1)
			throw new MessageException("End of stream reached.");
		if (size > 253)
			throw new MessageException("Packet length data in stream is too large (max 253, got " + size + ") ");
		if (size < 4)
			throw new MessageException("Packet length data in stream is too small (min 4, got " + size + ")");
		packet = new short[size + 1];
		
		bpacket = new byte[size];
		//System.out.println("psize in:"+size);
		packet[0] = (short) size;
		int readsize;
		int totalread = 0;
		int sizetoread=size;
		try {
			while ( totalread < size ) {
				readsize = in.read( bpacket, totalread, 1 /*sizetoread*/ );
				if ( readsize == -1 ) break;
				//System.out.println("--byte in :"+bpacket[totalread]);
				sizetoread -= readsize;
				totalread += readsize;
			}
			readsize = totalread;
		} catch (IOException e) {
			throw new MessageException("Error while reading stream for data after packet length field.", e);
		}
		if (readsize == -1)
			throw new MessageException("unexpected end of stream after reading packet length field.");
		if (readsize != size)
			throw new MessageException("Packet broken in stream, expected " + size + " bytes but received only " + readsize + ".");
		for (int i = 0; i < size; i++) {
			packet[i + 1] = (short) (0x00 << 24 | bpacket[i] & 0xff);
		}
		return packet;
	}

	public static void validatePacket(short[] packet) throws MessageException {
		if (packet == null)
			throw new MessageException("Null packet");
		if (packet.length == 0)
			throw new MessageException("Empty Packet");
		if (packet.length < 5)
			throw new MessageException("Too small packet : minimum is 5 , provided packet length is " + packet.length);
		if (packet.length > 256)
			throw new MessageException("Too large packet : maximum is 256, provided packet length is " + packet.length);
		int size = packet[PACKET_LENGTH];
		if ((size + 1) > packet.length)
			throw new MessageException(
					"Packet length field is too large compare to the provided packet data ( [packet length field + 1 = "
							+ size + " + 1 ] > [frame packet length = " + packet.length + "]");
	}
}
