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

public enum RFfirmwareType {
	TYPE1rec	(0x00, "Type1 RFXrec receive only firmware"),
	TYPE1		(0x01, "Type1"),
	TYPE2		(0x02, "Type2"),
	EXT			(0x03, "Ext"),
	EXT2		(0x04, "Ext2"),
	PRO1		(0x05, "Pro1"),
	PRO2		(0x06, "Pro2"),
	PROXL1		(0x10, "ProXL1"),
	UNKNOWN		(0xFF, "Unknown"),
	;
	
	RFfirmwareType(int type, String description) {
		this.type = type;
		this.description = description;
	}
	
	public static RFfirmwareType get(int itype) {
		for (RFfirmwareType aType: RFfirmwareType.values()) {
			if (aType.getType() == itype) {
				return aType;
			}
		}
		return UNKNOWN;
	}
	
	private final int type;
	private final String description;
	
	public int getType() {
		return type;
	}
	
	public String getDescription() {
		return description;
	}
}
