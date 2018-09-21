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

public enum RFxmitpwr {
	POWminus18	(0x00, "-18dBm"),
	POWminus17	(0x01, "-17dBm"),
	POWminus16	(0x02, "-16dBm"),
	POWminus15	(0x03, "-15dBm"),
	POWminus14	(0x04, "-14dBm"),
	POWminus13	(0x05, "-13dBm"),
	POWminus12	(0x06, "-12dBm"),
	POWminus11	(0x07, "-11dBm"),
	POWminus10	(0x08, "-10dBm"),
	POWminus09	(0x09, "-9dBm"),
	POWminus08	(0x0A, "-8dBm"),
	POWminus07	(0x0B, "-7dBm"),
	POWminus06	(0x0C, "-6dBm"),
	POWminus05	(0x0D, "-5dBm"),
	POWminus04	(0x0E, "-4dBm"),
	POWminus03	(0x0F, "-3dBm"),
	POWminus02	(0x10, "-2dBm"),
	POWminus01	(0x11, "-1dBm"),
	POWminus00	(0x12, "-0dBm"),
	POWplus00	(0x12, "+0dBm"),
	POWplus01	(0x13, "+1dBm"),
	POWplus02	(0x14, "+2dBm"),
	POWplus03	(0x15, "+3dBm"),
	POWplus04	(0x16, "+4dBm"),
	POWplus05	(0x17, "+5dBm"),
	POWplus06	(0x18, "+6dBm"),
	POWplus07	(0x19, "+7dBm"),
	POWplus08	(0x1A, "+8dBm"),
	POWplus09	(0x1B, "+9dBm"),
	POWplus10	(0x1C, "+10dBm"),
	POWplus11	(0x1D, "+11dBm"),
	POWplus12	(0x1E, "+12dBm"),
	POWplus13	(0x1F, "+13dBm"),
	Unknown		(0xFF, "Unknown transmitter power")
	;
	RFxmitpwr(int powId, String description) {
		this.powId = (short)powId;
		this.description = description;
	}
	
	private final short powId;
	private final String description;
	
	public short get() {
		return powId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static RFxmitpwr get(short freqId) {
		RFxmitpwr pow = RFxmitpwr.Unknown;
		for (RFxmitpwr apow: RFxmitpwr.values()) {
			if (apow.get() == freqId) {
				pow = apow;
				break;
			}
		}
		return pow;
	}
	
}
