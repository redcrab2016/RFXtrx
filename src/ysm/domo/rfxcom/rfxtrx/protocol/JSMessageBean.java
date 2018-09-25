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

/**
 * @author edevaux
 *
 */
public class JSMessageBean {

	
	private int messageType;
	private int messageSubtype;
	private int[] messageData;
	public static final int UNASSIGNED=-1;
	/**
	 * 
	 */
	public JSMessageBean() {
		messageType = UNASSIGNED;
		messageSubtype = UNASSIGNED;
		messageData = new int[] {UNASSIGNED};
	}
	public int getType() {
		return messageType;
	}
	public JSMessageBean setType(int messageType) {
		this.messageType = messageType;
		return this;
	}
	public int getSubtype() {
		return messageSubtype;
	}
	public JSMessageBean setSubtype(int messageSubtype) {
		this.messageSubtype = messageSubtype;
		return this;
	}
	public short[] getData() {
		short[] data = new short[messageData.length];
		for (int i=0 ; i < data.length ; i++) {
			data[i] = (short)messageData[i];
		}
		return data;
	}
	public JSMessageBean setData(int[] messageData) {
		this.messageData = messageData;
		return this;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append( "type:"+messageType +", subtype:"+messageSubtype);
		sb.append(", data:[");
		for (int i = 0 ; i< messageData.length ; i++) {
			if (i>0) sb.append(",");
			sb.append(messageData[i]);
		}
		sb.append(']');
		return sb.toString();
	}

	
}
