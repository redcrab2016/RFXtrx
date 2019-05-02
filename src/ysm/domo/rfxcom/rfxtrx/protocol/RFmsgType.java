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

import java.util.HashMap;
import java.util.Map;

/**
 * @author edevaux
 *
 */
public enum RFmsgType {
	UNDECODED_RF_MESSAGE(	0x03,	"Undecoded RF Message", 
			new String[] {"msg1","msg2","msg3","msg4","msg5","msg6","msg7","msg8","msg9","msg10","msg11","msg12","msg13","msg14","msg15","msg16","msg17","msg18","msg19","msg20","msg21","msg22","msg23","msg24","msg25","msg26","msg27","msg28","msg29","msg30","msg31","msg32","msg33"}),
	LIGHTING1			(	0x10,	"Lighting1", 
			new String[] {"housecode","unitcode","cmnd","signal"},
			new HashMap<String,String>() {{	put("cmnd","command()");put("housecode","hcode()");put("rssi","rssi()");}}),
	LIGHTING2			(	0x11,	"Lighting2", 
			new String[] {"id1","id2","id3","id4","unitcode","cmnd","level","signal"},
			new HashMap<String,String>() {{	put("id","id1_4()");put("cmnd","command()");put("housecode","hcode()");put("rssi","rssi()");}}),
	LIGHTING3			(	0x12,	"Lighting3", 
			new String[] {"system","channel8_1","channel10_9","cmnd","signal"},
			new HashMap<String,String>() {{	put("channel","channel1_10()");put("cmnd","command()");put("battery_level","battery_level()");put("rssi","rssi()");}}),
	LIGHTING4			(	0x13,	"Lighting4", 
			new String[] {"cmd1","cmd2","cmd3","pulseHigh","pulseLow","signal"},
			new HashMap<String,String>() {{	put("pulse","pulse()");	put("rssi","rssi()");}}),
	LIGHTING5			(	0x14,	"Lighting5", 
			new String[] {"id1","id2","id3","unitcode","cmnd","level","signal"},
			new HashMap<String,String>() {{	put("id","id1_3()");put("cmnd","command()");put("rssi","rssi()");}}),
	LIGHTING6			(	0x15,	"Lighting6", 
			new String[] {"id1","id2","groupcode","unitcode","cmnd","cmndseqnbr","seqnbr2","signal"},
			new HashMap<String,String>() {{	put("id","id1_2()");put("cmnd","command()");put("rssi","rssi()");}}),
	CHIME				(	0x16,	"Chime", 
			new String[] {"id1","id2","sound","signal"}),
	FAN					(	0x17,	"Fan", 
			new String[] {"id1","id2","id3","cmnd","signal"} ),
	CURTAIN1			(	0x18,	"Curtain1", 
			new String[] {"housecode","unitcode","cmnd","signal"}),
	BLINDS1				(	0x19,	"Blinds1", 
			new String [] {"id1","id2","id3","id4unitcode","cmnd","signal"}),
	RFY					(	0x1A,	"RFY", 
			new String[] {"id1","id2","id3","unitcode","cmnd","rfu1","rfu2","rfu3","signal"}),
	HOME_CONFORT		(	0x1B,	"Home Confort", 
			new String[] {"id1","id2","id3","housecode","unitcode","cmnd","rfu1","rfu2","signal"}),
	EDISIO				(	0x1C,	"Edisio", 
			new String[] {"id1","id2","id3","id4","unitcode","cmnd","level","R","G","B","maxrepeat","repeatcnt","signal"}),
	HONEYWELL_ACTIVLINK	(	0x1D,	"Honeywell ActivLink(TM)", 
			new String[] {"id1","id2","id3","id4","id5","id6","rfu","signal"}),
	FUNKBUS				(	0x1E,	"FunkBus", 
			new String[] {"id1","id2","groupcode","unitcode","cmnd","cmndtime","devtype","signal"}),
	SECURITY1			(	0x20,	"Security1", 
			new String[] {"id1", "id2", "id3", "status","signal"},
			new HashMap<String,String>() {{	put("id","id1_3()");put("status","status_sec1()");put("battery_level","battery_level()");put("rssi","rssi()");}}),
	SECURITY2			(   0x21,	"Security2", 
			new String[] {"id1","id2","id3","id4","id5","id6","id7","id8","id9","id10","id11","id12","id13","id14","id15","id16","id17","id18","id19","id20","id21","id22","id23","id24","signal"}),
	CAMERA1				(	0x28,	"Camera1", 
			new String[] {"housecode","cmnd","signal"}),
	REMOTE_CONTROL_IR	(	0x30,	"Remote control and IR", 
			new String[] {"id","cmnd","signal4_toggle1_cmndtype3"}),
	THERMOSTAT1			(	0x40,	"Thermostat1", 
			new String[] {"id1","id2","temperature","set_point","mode1_filler5_status2","signal"}),
	THERMOSTAT2			(	0x41,	"Thermostat2", 
			new String[] {"unitcode","cmnd","signal"}),
	THERMOSTAT3			(	0x42,	"Thermostat3", 
			new String[] {"unitcode1","unitcode2","unitcode3","cmnd","signal"}),
	THERMOSTAT4			(	0x43,	"Thermostat4", 
			new String[] {"unitcode1","unitcode3","unitcode3","beep","fan1_speed","fan3_speed_fan2_speed","flame_power","mode","signal"}),
	RADIATOR1			(	0x48,	"Radiator1", 
			new String[] {"id1","id2","id3","id4","unitcode","cmnd","temperature","tempPoint5","signal"}),
	BBQ_TEMP_SENSORS	(	0x4E,	"BBQ Temperature sensors",
			new String[] {"id1","id2","sensor1high","sensor1low","sensor2high","sensor2low","signal"}),
	TEMP_RAIN_SENSORS	(	0x4F,	"Temperature and rain sensors", 
			new String[] {"id1","id2","sign1_tempraturehigh","temperaturelow","raintotal1","raintotal2","signal"}),
	TEMP_SENSORS		(	0x50,	"Temperature sensors", 
			new String[] {"id1","id2","sign1_temperaturehigh","temperaturelow","signal"}),
	HUM_SENSORS			(	0x51,	"Humidity sensors", 
			new String[] {"id1","id2","humidity","humidity_status","signal"}),
	TEMP_HUM_SENSORS	(	0x52,	"Temperature and humidity sensors", 
			new String[] {"id1","id2","sign1_temperaturehigh","temperaturelow","humidity","humidity_status","signal"}),
	BARO_SENSORS		(	0x53,	"Barometric sensors", 
			new String[] {"id1","id2","baro1","baro2","forecast","signal"}),
	TEMP_HUM_BARO_SENSORS(	0x54,	"Temperature, humidity and barometric sensors", 
			new String[] {"id1","id2","sign1_temperaturehigh","temperaturelow","humidity","humidity_status","baro1","baro2","forecast","signal"}),
	RAIN_SENSORS		(	0x55,	"Rain sensors", 
			new String[] {"id1","id2","rainratehigh","rainratelow","raintotal1","raintotal2","raintotal3","signal"}),
	WIND_SENSORS		(	0x56,	"Wind sensors", 
			new String[] {"id1","id2","directionhigh","directionlow","av_speedhigh","av_speedlow","gusthigh","gustlow","sign1_temperaturehigh","temperaturelow","sign1_chillhigh","chilllow","signal"}),
	UV_SENSORS			(	0x57,	"UV sensors", 
			new String[] {"id1","id2","uv","sign1_temperaturehigh","temperaturelow","signal"}),
	DATE_TIME_SENSORS	(	0x58,	"Date/Time sensors", 
			new String[] {"id1","id2","yy","mm","dd","dow","hr","min","sec","signal"}),
	CURRENT_SENSORS		(	0x59,	"Current sensors", 
			new String[] {"id1","id2","count","ch1_high","ch1_low","ch2_high","ch2_low","ch3_high","ch3_low","sinal"}),
	ENERGY_SENSORS		(	0x5A,	"Energy usage sensors", 
			new String[] {"id1","id2","count","instant1","instant2","instant3","instant4","total1","total2","total3","total4","total5","total6","signal"}),
	CURRENT_ENERGY_SENSORS(	0x5B,	"Current + ENERGY sensors", 
			new String[] {"id1","id2","count","ch1_high","ch1_low","ch2_high","ch2_low","ch3_high","ch3_low","total1","total2","total3","total4","total5","total6","signal"}),
	POWER_SENSORS		(	0x5C,	"Power sensors", 
			new String[] {"id1","id2","voltage","currentH","currentL","powerH","powerL","energyH","energyL","pf","freq","signal"}),
	WEIGHTING_SCALE		(	0x5D,	"Weighting scale", 
			new String[] {"id1","id2","weighthigh","weightlow","signal"}),
	GAS_SENSORS			(	0x5E,	"gas usage sensors", 
			new String[] {}),
	WATER_SENSORS		(	0x5F,	"Water usage sensors", 
			new String[] {}),
	CARTELECTRONIC		(	0x60,	"CARTELECTRONIC", 
			new String[]{} ),
	ASYNC_PORT_CONF		(	0x61,	"ASYNC port configuration", 
			new String[] {"cmnd","baudrate","parity","databits","stopbits","polarity","filler1","filler2"}),
	ASYNC_TXRX			(	0x62,	"Async transmit/receive", 
			new String[] {}),
	RFXSENSOR			(	0x70,	"RFXsensor", 
			new String[] {"id","msg1","msg2","signal"}),
	RFXMETER			(	0x71,	"RFXMeter", 
			new String[] {"id1","id2","count1","count2","count3","count4","signal"}),
	FS20				(	0x72,	"FS20", 
			new String[] {"hc1","hc2","addr","cmd1","cmd2","signal"}),
	RAW_TXRX			(	0x7F,	"RAW transmit/receive", 
			new String[] {"repeat"})
	;
	RFmsgType(int msgType, String description, String[] datamapping, Map<String,String> datacompute) {
		this.msgType = (short)msgType;
		this.description = description;
		this.dataMapping = datamapping;
		this.dataCompute = datacompute;
	}

	RFmsgType(int msgType, String description, String[] datamapping) {
		this.msgType = (short)msgType;
		this.description = description;
		this.dataMapping = datamapping;
		this.dataCompute = new HashMap<String,String>();
	}
		
	private final short msgType;
	private final String description;
	private final String[] dataMapping;
	private final Map<String,String> dataCompute;
	
	public short getMsgType() {
		return msgType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String[] getMapping() {
		return dataMapping;
	}
	
	public Map<String,String> getCompute() {
		return dataCompute;
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
