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
public enum RFmsgType {
	UNDECODED_RF_MESSAGE(	0x03,	"Undecoded RF Message"),
	LIGHTING1			(	0x10,	"Lighting1"),
	LIGHTING2			(	0x11,	"Lighting2"),
	LIGHTING3			(	0x12,	"Lighting3"),
	LIGHTING4			(	0x13,	"Lighting4"),
	LIGHTING5			(	0x14,	"Lighting5"),
	LIGHTING6			(	0x15,	"Lighting6"),
	CHIME				(	0x16,	"Chime"),
	FAN					(	0x17,	"Fan" ),
	CURTAIN1			(	0x18,	"Curtain1"),
	BLINDS1				(	0x19,	"Blinds1"),
	RFY					(	0x1A,	"RFY"),
	HOME_CONFORT		(	0x1B,	"Home Confort"),
	EDISIO				(	0x1C,	"Edisio"),
	HONEYWELL_ACTIVLINK	(	0x1D,	"Honeywell ActivLink(TM)"),
	FUNKBUS				(	0x1E,	"FunkBus"),
	SECURITY1			(	0x20,	"Security1"),
	SECURITY2			(   0x21,	"Security2"),
	CAMERA1				(	0x28,	"Camera1"),
	REMOTE_CONTROL_IR	(	0x30,	"Remote control and IR"),
	THERMOSTAT1			(	0x40,	"Thermostat1"),
	THERMOSTAT2			(	0x41,	"Thermostat2"),
	THERMOSTAT3			(	0x42,	"Thermostat3"),
	THERMOSTAT4			(	0x43,	"Thermostat4"),
	RADIATOR1			(	0x48,	"Radiator1"),
	BBQ_TEMP_SENSORS	(	0x4E,	"BBQ Temperature sensors"),
	TEMP_RAIN_SENSORS	(	0x4F,	"Temperature and rain sensors"),
	TEMP_SENSORS		(	0x50,	"Temperature sensors"),
	HUM_SENSORS			(	0x51,	"Humidity sensors"),
	TEMP_HUM_SENSORS	(	0x52,	"Temperature and humidity sensors"),
	BARO_SENSORS		(	0x53,	"Barometric sensors"),
	TEMP_HUM_BARO_SENSORS(	0x54,	"Temperature, humidity and barometric sensors"),
	RAIN_SENSORS		(	0x55,	"Rain sensors"),
	WIND_SENSORS		(	0x56,	"Wind sensors"),
	UV_SENSORS			(	0x57,	"UV sensors"),
	DATE_TIME_SENSORS	(	0x58,	"Date/Time sensors"),
	CURRENT_SENSORS		(	0x59,	"Current sensors"),
	ENERGY_SENSORS		(	0x5A,	"Energy usage sensors"),
	CURRENT_ENERGY_SENSORS(	0x5B,	"Current + ENERGY sensors"),
	POWER_SENSORS		(	0x5C,	"Power sensors"),
	WEIGHTING_SCALE		(	0x5D,	"Weighting scale"),
	GAS_SENSORS			(	0x5E,	"gas usage sensors"),
	WATER_SENSORS		(	0x5F,	"Water usage sensors"),
	CARTELECTRONIC		(	0x60,	"CARTELECTRONIC"),
	ASYNC_PORT_CONF		(	0x61,	"ASYNC port configuration"),
	ASYNC_TXRX			(	0x62,	"Async transmit/receive"),
	RFXSENSOR			(	0x70,	"RFXsensor"),
	RFXMETER			(	0x71,	"RFXMeter"),
	FS20				(	0x72,	"FS20"),
	RAW_TXRX			(	0x7F,	"RAW transmit/receive")
	;
	RFmsgType(int msgType, String description) {
		this.msgType = (short)msgType;
		this.description = description;
	}
	
	private final short msgType;
	private final String description;
	
	public short getMsgType() {
		return msgType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static RFmsgType get(int msgType) {
		for (RFmsgType aMsgType : RFmsgType.values()) {
			if (aMsgType.getMsgType() == msgType) {
				return aMsgType;
			}
		}
		return null;
	}
}
