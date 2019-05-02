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

public enum RFmsgSubtype {
	UNDECODED_RF_MESSAGE_AC				(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x00,	"ac"),
	UNDECODED_RF_MESSAGE_ARC			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x01,	"arc"),
	UNDECODED_RF_MESSAGE_ATI			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x02,	"ati"),
	UNDECODED_RF_MESSAGE_HIDEKI			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x03,	"hideki/upm"),
	UNDECODED_RF_MESSAGE_UPM			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x03,	"hideki/upm"),
	UNDECODED_RF_MESSAGE_LACROSSE		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x04,	"lacrosse/viking"),
	UNDECODED_RF_MESSAGE_VIKING			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x04,	"lacrosse/viking"),
	UNDECODED_RF_MESSAGE_AD				(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x05,	"ad"),
	UNDECODED_RF_MESSAGE_MERTIK			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x06,	"mertik"),
	UNDECODED_RF_MESSAGE_OREGON1		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x07,	"oregon1"),
	UNDECODED_RF_MESSAGE_OREGON2		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x08,	"oregon2"),
	UNDECODED_RF_MESSAGE_OREGON3		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x09,	"oregon3"),
	UNDECODED_RF_MESSAGE_PROGUARD		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0A,	"proguard"),
	UNDECODED_RF_MESSAGE_VISONIC		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0B,	"visonic"),
	UNDECODED_RF_MESSAGE_NEC			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0C,	"nec"),
	UNDECODED_RF_MESSAGE_FS20			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0D,	"fs20"),
	UNDECODED_RF_MESSAGE_RESERVED		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0E,	"reserved"),
	UNDECODED_RF_MESSAGE_BLINDS			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x0F,	"blinds"),
	UNDECODED_RF_MESSAGE_RUBICSON		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x10,	"rubicson"),
	UNDECODED_RF_MESSAGE_AE				(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x11,	"ae"),
	UNDECODED_RF_MESSAGE_FINEOFFSET		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x12,	"fineoffset"),
	UNDECODED_RF_MESSAGE_RGB			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x13,	"rgb"),
	UNDECODED_RF_MESSAGE_RTS			(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x14,	"rts"),
	UNDECODED_RF_MESSAGE_SELECTPLUS		(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x15,	"selectplus"),
	UNDECODED_RF_MESSAGE_HOMECONFORT	(	-1,	RFmsgType.UNDECODED_RF_MESSAGE,	0x16,	"homeconfort"),
	
	LIGHTING1_X10						(	0x07,	RFmsgType.LIGHTING1,			0x00,	"X10 lighting"),
	LIGHTING1_ARC						(	0x07,	RFmsgType.LIGHTING1,			0x01,	"ARC"),
	LIGHTING1_ELRO_AB400D_FLAMINGO		(	0x07,	RFmsgType.LIGHTING1,			0x02,	"ELRO AB400D (Flamingo)"),
	LIGHTING1_WAVEMAN					(	0x07,	RFmsgType.LIGHTING1,			0x03,	"Waveman"),
	LIGHTING1_CHACON_EMW200				(	0x07,	RFmsgType.LIGHTING1,			0x04,	"Chacon EMW200"),
	LIGHTING1_IMPULS					(	0x07,	RFmsgType.LIGHTING1,			0x05,	"IMPULS"),
	LIGHTING1_RISINGSUN					(	0x07,	RFmsgType.LIGHTING1,			0x06,	"RisingSun"),
	LIGHTING1_PHILIPS_SBC				(	0x07,	RFmsgType.LIGHTING1,			0x07,	"Philips SBC"),
	LIGHTING1_ENERGENIE_ENER010			(	0x07,	RFmsgType.LIGHTING1,			0x08,	"Energenie ENER010"),
	LIGHTING1_ENERGENIE_5_GANG			(	0x07,	RFmsgType.LIGHTING1,			0x09,	"Energenie 5-gang"),
	LIGHTING1_COCO_GDR2_2000R			(	0x07,	RFmsgType.LIGHTING1,			0x0A,	"COCO GRD2-2000R"),
	LIGHTING1_HQ_COCO_20				(	0x07,	RFmsgType.LIGHTING1,			0x0B,	"HQ COCO-20"),
	LIGHTING1_OASE_INSCENION_FM_MASTER	(	0x07,	RFmsgType.LIGHTING1,			0x0C,	"Oase Inscenio FM Master"),
	
	LIGHTING2_AC						(	0x0B,	RFmsgType.LIGHTING2,			0x00,	"AC (KlikAanKlikUit,HomeEasyUK,Chacon,NEXA,Intertechno…)"),
	LIGHTING2_HOMEEASY_EU				(	0x0B,	RFmsgType.LIGHTING2,			0x01,	"HomeEasy EU"),
	LIGHTING2_ANSLUT					(	0x0B,	RFmsgType.LIGHTING2,			0x02,	"ANSLUT"),
	LIGHTING2_KAMBROOK_RF3672			(	0x0B,	RFmsgType.LIGHTING2,			0x03,	"Kambrook RF3672 (Australia)"),
	
	LIGHTING3_KOPPLA					(	0x08,	RFmsgType.LIGHTING3,			0x00,	"Ikea Koppla"),
	
	LIGHTING4_PT2262					(	0x09,	RFmsgType.LIGHTING4,			0x00,	"PT2262, EV1527 (433.92MHz)"),
	LIGHTING4_EV1527					(	0x09,	RFmsgType.LIGHTING4,			0x00,	"PT2262, EV1527 (433.92MHz)"),

	LIGHTING5_LIGHTWARERF				(	0x0A,	RFmsgType.LIGHTING5,			0x00,	"LightwaveRF, Siemens (AD protocol)"),
	LIGHTING5_SIEMENS					(	0x0A,	RFmsgType.LIGHTING5,			0x00,	"LightwaveRF, Siemens (AD protocol)"),
	LIGHTING5_EMW100_GAO_EVERFLOURISH	(	0x0A,	RFmsgType.LIGHTING5,			0x01,	"EMW100 GAO/Everflourish"),
	LIGHTING5_BBSB_NEW_TYPES			(	0x0A,	RFmsgType.LIGHTING5,			0x02,	"BBSB new types"),
	LIGHTING5_MDREMOTE_106_LED_DIMMER	(	0x0A,	RFmsgType.LIGHTING5,			0x03,	"MDREMOTE 106 LED dimmer"),
	LIGHTING5_CONRAD_RSL2_OTIO			(	0x0A,	RFmsgType.LIGHTING5,			0x04,	"Conrad RSL2, OTIO"),
	LIGHTING5_LIVOLO_DIMMER_ONOFF_1_3	(	0x0A,	RFmsgType.LIGHTING5,			0x05,	"Livolo Dimmer or On/Off 1-3"),
	LIGHTING5_RGB_TRC02					(	0x0A,	RFmsgType.LIGHTING5,			0x06,	"RGB TRC02 (2 batt)"),
	LIGHTING5_AOKE_RELAY				(	0x0A,	RFmsgType.LIGHTING5,			0x07,	"Aoke Relay"),
	LIGHTING5_RGB_TRC02_2				(	0x0A,	RFmsgType.LIGHTING5,			0x08,	"RGB TRC02_2 (3 batt)"),
	LIGHTING5_EURODOMEST				(	0x0A,	RFmsgType.LIGHTING5,			0x09,	"Eurodomest"),
	LIGHTING5_LIVOLO_1_10				(	0x0A,	RFmsgType.LIGHTING5,			0x0A,	"Livolo 1-10"),
	LIGHTING5_RGB432W					(	0x0A,	RFmsgType.LIGHTING5,			0x0B,	"RGB432W"),
	LIGHTING5_MDREMOTE_107_LED_DIMMER	(	0x0A,	RFmsgType.LIGHTING5,			0x0C,	"MDREMOTE 107 LED dimmer"),
	LIGHTING5_LEGRAND_CAD				(	0x0A,	RFmsgType.LIGHTING5,			0x0D,	"Legrand CAD"),
	LIGHTING5_AVANTEK					(	0x0A,	RFmsgType.LIGHTING5,			0x0E,	"Avantek"),
	LIGHTING5_IT						(	0x0A,	RFmsgType.LIGHTING5,			0x0F,	"IT (FA500,PROmax…)"),
	LIGHTING5_MDREMOTE_108_LED_DIMMER	(	0x0A,	RFmsgType.LIGHTING5,			0x10,	"MDREMOTE 108 LED dimmer"),
	LIGHTING5_KANGTAI_COTECH			(	0x0A,	RFmsgType.LIGHTING5,			0x11,	"Kangtai,Cotech"),
	
	LIGHTING6_BLYSS						(	0x0B,	RFmsgType.LIGHTING6,			0x00,	"Blyss"),
	LIGHTING6_CUEVO						(	0x0B,	RFmsgType.LIGHTING6,			0x01,	"Cuevo"),

	CHIME_BYRON_SX						(	0x07,	RFmsgType.CHIME,				0x00,	"Byron SX"),
	CHIME_BYRON_MP001					(	0x07,	RFmsgType.CHIME,				0x01,	"Byron MP001"),
	CHIME_SELECTPLUS					(	0x07,	RFmsgType.CHIME,				0x02,	"SelectPlus"),
	CHIME_RFU							(	0x07,	RFmsgType.CHIME,				0x03,	"RFU (was selectplus103)"),
	CHIME_ENVIVO						(	0x07,	RFmsgType.CHIME,				0x04,	"Envivo"),
	
	FAN_SIEMENS							(	0x08,	RFmsgType.FAN,					0x00,	"Siemens/Wave Design SF01 -  LF959RA50/LF259RB50/LF959RB50 extractor hood (433MHz)"),	
	FAN_ITHO_CVE_RFT					(	0x08,	RFmsgType.FAN,					0x01,	"Itho CVE RFT (868MHz)"),
	FAN_LUCCI_AIR_FAN					(	0x08,	RFmsgType.FAN,					0x02,	"Lucci Air fan"),
	FAN_SEAV_TXS4						(	0x08,	RFmsgType.FAN,					0x03,	"SEAV TXS4"),
	FAN_WESTINGHOUSE_7226640			(	0x08,	RFmsgType.FAN,					0x04,	"Westinghouse 7226640"),
	FAN_LUCCI_AIR_DC					(	0x08,	RFmsgType.FAN,					0x05,	"Lucci Air DC"),
	FAN_CASAFAN							(	0x08,	RFmsgType.FAN,					0x06,	"Casafan"),
	FAN_FT1211R_FAN_CONTROLLER			(	0x08,	RFmsgType.FAN,					0x07,	"FT1211R fan controller"),
	FAN_FALMEC							(	0x08,	RFmsgType.FAN,					0x08,	"Falmec"),
	FAN_LUCCI_AIR_DCII					(	0x08,	RFmsgType.FAN,					0x09,	"Lucci Air DCII"),
	
	CURTAIN1_HARRISON					(	0x07,	RFmsgType.CURTAIN1,				0x00,	"Harrison Curtain"),
	
	BLINDS1_T0							(	0x09,	RFmsgType.BLINDS1,				0x00,	"BlindsT0 = Bofu, RollerTrol, Hasta new, Louvolite"),
	BLINDS1_T1							(	0x09,	RFmsgType.BLINDS1,				0x01,	"BlindsT1 = Hasta old"),
	BLINDS1_T2							(	0x09,	RFmsgType.BLINDS1,				0x02,	"BlindsT2 = A-OK RF01"),
	BLINDS1_T3							(	0x09,	RFmsgType.BLINDS1,				0x03,	"BlindsT3 = A-OK AC114/AC123/Motorlux"),
	BLINDS1_T4							(	0x09,	RFmsgType.BLINDS1,				0x04,	"BlindsT4 = Raex YR1326"),
	BLINDS1_T5							(	0x09,	RFmsgType.BLINDS1,				0x05,	"BlindsT5 = Media Mount"),
	BLINDS1_T6							(	0x09,	RFmsgType.BLINDS1,				0x06,	"BlindsT6 = DC106/Rohrmotor24-RMF/Yooda/Dooya/ ESMO/Brel/Quitidom"),
	BLINDS1_T7							(	0x09,	RFmsgType.BLINDS1,				0x07,	"BlindsT7 = Forest"),
	BLINDS1_T8							(	0x09,	RFmsgType.BLINDS1,				0x08,	"BlindsT8 = Chamberlain CS4330CN"),
	BLINDS1_T9							(	0x09,	RFmsgType.BLINDS1,				0x09,	"BlindsT9 = Sunpery/BTX"),
	BLINDS1_T10							(	0x09,	RFmsgType.BLINDS1,				0x0A,	"BlindsT10 = Dolat DLM-1, Topstar"),
	BLINDS1_T11							(	0x09,	RFmsgType.BLINDS1,				0x0B,	"BlindsT11 = ASP"),
	BLINDS1_T12							(	0x09,	RFmsgType.BLINDS1,				0x0C,	"BlindsT12 = Confexx CNF24-2435"),
	BLINDS1_T13							(	0x09,	RFmsgType.BLINDS1,				0x0D,	"BlindsT13 = Screenline"),
	BLINDS1_T14							(	0x09,	RFmsgType.BLINDS1,				0x0E,	"BlindsT14 = Hualite"),
	BLINDS1_T15							(	0x09,	RFmsgType.BLINDS1,				0x0F,	"BlindsT15 = RFU for Motivia"),
	BLINDS1_T16							(	0x09,	RFmsgType.BLINDS1,				0x10,	"BlindsT16 = Zemismart"),
	
	
	RFY_SOMFY_RTS_SIMU					(	0x0C,	RFmsgType.RFY,					0x00,	"RFY - Somfy RTS,Simu"),
	RFY_EXT								(	0x0C,	RFmsgType.RFY,					0x01,	"RFY ext"),
	RFY_RESERVED						(	0x0C,	RFmsgType.RFY,					0x02,	"reserved"),
	RFY_ASA								(	0x0C,	RFmsgType.RFY,					0x03,	"ASA"),
	
	HOMECONFORT_TEL_010					(	0x0C,	RFmsgType.HOME_CONFORT,			0x00,	"TEL-010"),
	
	EDISIO								(	0x11,	RFmsgType.EDISIO,				0x00,	"Controller"),
	
	HONEYWELL_ACTIVLINK_SERIES_5_CHIME	(	0x0B,	RFmsgType.HONEYWELL_ACTIVLINK,	0x00,	"Series 5 Chime"),
	
	FUNKBUS_GIRA_REMOTE					(	0x0B,	RFmsgType.FUNKBUS,				0x00,	"Gira remote, wall switch"),
	FUNKBUS_INSTA_REMOTE				(	0x0B,	RFmsgType.FUNKBUS,				0x01,	"Insta remote, wall switch"),
	
	SECURITY1_X10_DOOR_WINDOW_SENSORS	(	0x08,	RFmsgType.SECURITY1,			0x00,	"X10 security door/window sensor"),
	SECURITY1_X10_MOTION_SENSORS		(	0x08,	RFmsgType.SECURITY1,			0x01,	"X10 security motion sensor"),
	SECURITY1_X10_REMOTE				(	0x08,	RFmsgType.SECURITY1,			0x02,	"X10 security remote"),
	SECURITY1_KD101						(	0x08,	RFmsgType.SECURITY1,			0x03,	"KD101"),
	SECURITY1_VISONIC_PC_DOOR_WINDOW_SENSOR_PRIMARY_CONTACT	(	0x08,	RFmsgType.SECURITY1,			0x04,	"Visonic PowerCode door/window sensor – primary contact"),
	SECURITY1_VISONIC_PC_MORTION_SENSOR	(	0x08,	RFmsgType.SECURITY1,			0x05,	"Visonic PowerCode motion sensor"),
	SECURITY1_VISONIC_CODESECURE		(	0x08,	RFmsgType.SECURITY1,			0x06,	"Visonic CodeSecure"),
	SECURITY1_VISONIC_PC_DOOR_WINDOW_SENSOR_AUXILIARY_CONTACT	(	0x08,	RFmsgType.SECURITY1,			0x07,	"Visonic PowerCode door/window sensor – auxiliary contact"),
	SECURITY1_MEIANTECH_ATLANTIC		(	0x08,	RFmsgType.SECURITY1,			0x08,	"Meiantech,Atlantic"),
	SECURITY1_SA30_SA33					(	0x08,	RFmsgType.SECURITY1,			0x09,	"SA30, SA33"),
	SECURITY1_RM174RF					(	0x08,	RFmsgType.SECURITY1,			0x0A,	"RM174RF"),
	
	SECURITY2_RAW_CLASSIC_KEELOQ_PACKET	(	0x1C,	RFmsgType.SECURITY2,			0x00,	"raw Classic KeeLoq packet "),
	SECURITY2_ROLLING_CODE_PACKET		(	0x1C,	RFmsgType.SECURITY2,			0x01,	"rolling code packet"),
	SECURITY2_RAW_AES_KEELOQ			(	0x1C,	RFmsgType.SECURITY2,			0x02,	"raw AES KeeLoq"),
	SECURITY2_RAW_CLASSIC_KEELOQ_PACKET2(	0x1C,	RFmsgType.SECURITY2,			0x03,	"raw Classic KeeLoq packet"),
	
	
	CAMERA1_X10_NINJA					(	0x06,	RFmsgType.CAMERA1,				0x00,	"X10 Ninja"),
	
	REMOTE_CONTROL_IR_ATI_REMOTE_WONDER	(	0x06,	RFmsgType.REMOTE_CONTROL_IR,	0x00,	"ATI Remote Wonder"),
	REMOTE_CONTROL_IR_ATI_REMOTE_WONDERP(	0x06,	RFmsgType.REMOTE_CONTROL_IR,	0x01,	"ATI Remote Wonder Plus"),
	REMOTE_CONTROL_IR_MEDION_REMOTE		(	0x06,	RFmsgType.REMOTE_CONTROL_IR,	0x02,	"Medion Remote"),
	REMOTE_CONTROL_X10_PC_REMOTE		(	0x06,	RFmsgType.REMOTE_CONTROL_IR,	0x03,	"X10 PC Remote"),
	REMOTE_CONTROL_IR_ATI_REMOTE_WONDER2(	0x06,	RFmsgType.REMOTE_CONTROL_IR,	0x04,	"ATI Remote Wonder II"),
	
	THERMOSTAT1_DIGIMAX_TLX7506			(	0x09,	RFmsgType.THERMOSTAT1,			0x00,	"Digimax, TLX7506"),
	THERMOSTAT1_DIGIMAX_SHORT_FORMAT	(	0x09,	RFmsgType.THERMOSTAT1,			0x01,	"Digimax, with short format"),
	
	THERMOSTAT2_HE105					(	0x06,	RFmsgType.THERMOSTAT2,			0x00,	"HE105"),
	THERMOSTAT2_RTS10_RFS10_TLX1206		(	0x06,	RFmsgType.THERMOSTAT2,			0x01,	"RTS10, RFS10, TLX1206"),
	
	THERMOSTAT3_MERTIK_G6RH4T1			(	0x08,	RFmsgType.THERMOSTAT3,			0x00,	"Mertik G6R-H4T1"),
	THERMOSTAT3_MERTIK_G6RH4TB			(	0x08,	RFmsgType.THERMOSTAT3,			0x01,	"Mertik G6R-H4TB / G6-H4T / G6R-H4T21-Z22"),
	THERMOSTAT3_MERTIK_G6RH4TD			(	0x08,	RFmsgType.THERMOSTAT3,			0x02,	"Mertik G6R-H4TD / G6R-H4T16"),
	THERMOSTAT3_MERTIK_G6RH4S			(	0x08,	RFmsgType.THERMOSTAT3,			0x03,	"Mertik G6R-H4S"),
	
	THERMOSTAT4_MCZ_1_FAN_MODEL			(	0x0C,	RFmsgType.THERMOSTAT4,			0x00,	"MCZ 1 fan model"),
	THERMOSTAT4_MCZ_2_FAN_MODEL			(	0x0C,	RFmsgType.THERMOSTAT4,			0x01,	"MCZ 2 fan model"),
	THERMOSTAT4_MCZ_3_FAN_MODEL			(	0x0C,	RFmsgType.THERMOSTAT4,			0x02,	"MCZ 3 fan model"),
	
	RADIATOR1_SMARTWARES				(	0x0C,	RFmsgType.RADIATOR1,			0x00,	" Smartwares 433.92MHz radiator valve"),

	BBQ_TEMP_SENSORS_BBQ1				(	0x0A,	RFmsgType.BBQ_TEMP_SENSORS,		0x00,	"Maverick ET-732"),
	
	TEMP_RAIN_SENSORS_TR1				(	0x0A,	RFmsgType.TEMP_RAIN_SENSORS,	0x00,	"Alecto WS1200"),

	TEMP_SENSORS_TEMP1					(	0x08,	RFmsgType.TEMP_SENSORS,			0x01,	"THR128/138, THC138, Davis"),
	TEMP_SENSORS_TEMP2					(	0x08,	RFmsgType.TEMP_SENSORS,			0x02,	"THC238/268,THN132,THWR288,THRN122,THN122,AW129/131,THN129"),
	TEMP_SENSORS_TEMP3					(	0x08,	RFmsgType.TEMP_SENSORS,			0x03,	"THWR800"),
	TEMP_SENSORS_TEMP4					(	0x08,	RFmsgType.TEMP_SENSORS,			0x04,	"RTHN318"),
	TEMP_SENSORS_TEMP5					(	0x08,	RFmsgType.TEMP_SENSORS,			0x05,	"La Crosse TX2, TX3, TX4, TX17"),
	TEMP_SENSORS_TEMP6					(	0x08,	RFmsgType.TEMP_SENSORS,			0x06,	"TS15C. UPM temp only"),
	TEMP_SENSORS_TEMP7					(	0x08,	RFmsgType.TEMP_SENSORS,			0x07,	"Viking 02811/02813, Proove TSS330, 311346"),
	TEMP_SENSORS_TEMP8					(	0x08,	RFmsgType.TEMP_SENSORS,			0x08,	"La Crosse WS2300"),
	TEMP_SENSORS_TEMP9					(	0x08,	RFmsgType.TEMP_SENSORS,			0x09,	"Rubicson, Auriol Z31055B-TX, WSD10"),
	TEMP_SENSORS_TEMP10					(	0x08,	RFmsgType.TEMP_SENSORS,			0x0A,	"TFA 30.3133, 30.3056, 30.3160 pool sensor"),
	TEMP_SENSORS_TEMP11					(	0x08,	RFmsgType.TEMP_SENSORS,			0x0B,	"WT0122"),
	

	HUM_SENSORS_HUM1					(	0x08,	RFmsgType.HUM_SENSORS,			0x01,	"LaCrosse TX3, Davis, Alecto ACH2010"),
	HUM_SENSORS_HUM2					(	0x08,	RFmsgType.HUM_SENSORS,			0x02,	"LaCrosse WS2300"),
	HUM_SENSORS_HUM3					(	0x08,	RFmsgType.HUM_SENSORS,			0x03,	"Inovalley S80 plant humidity sensor"),
	
	TEMP_HUM_SENSORS_TH1				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x01,	"THGN122/123, THGN132, THGR122/228/238/268"),
	TEMP_HUM_SENSORS_TH2				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x02,	"THGR810, THGN800, THGN801"),
	TEMP_HUM_SENSORS_TH3				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x03,	"RTGR328, THGN318, RTGR368, RTGR383"),
	TEMP_HUM_SENSORS_TH4				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x04,	"THGR328"),
	TEMP_HUM_SENSORS_TH5				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x05,	"WTGR800"),
	TEMP_HUM_SENSORS_TH6				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x06,	"THGR918/928, THGRN228, THGN500"),
	TEMP_HUM_SENSORS_TH7				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x07,	"TFA TS34C/Cresta/Honeywell TS33C"),
	TEMP_HUM_SENSORS_TH8				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x08,	"WT260,WT260H,WT440H,WT450,WT450H"),
	TEMP_HUM_SENSORS_TH9				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x09,	"Viking 02035,02038 (02035 has no humidity), Proove TSS320, 311501"),
	TEMP_HUM_SENSORS_TH10				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x0A,	"Rubicson,IW008T,TX95,Xiron-EN6,WH5"),
	TEMP_HUM_SENSORS_TH11				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x0B,	"EW109"),
	TEMP_HUM_SENSORS_TH12				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x0C,	"Imagintronix/Opus XT300 Soil sensor"),
	TEMP_HUM_SENSORS_TH13				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x0D,	"Alecto WS1700 and compatibles"),
	TEMP_HUM_SENSORS_TH14				(	0x0A,	RFmsgType.TEMP_HUM_SENSORS,		0x0E,	"Alecto WS3500, WS4500, Auriol H13726, Hama EWS1500, Meteoscan W155/W160,Ventus WS155"),
	
	BARO_SENSORS_0X01					(	0x09,	RFmsgType.BARO_SENSORS,			0x01,	"?"),
	
	TEMP_HUM_BARO_SENSORS_THB1			(	0x0D,	RFmsgType.TEMP_HUM_BARO_SENSORS,0x01,	"BTHR918, BTHGN129"),
	TEMP_HUM_BARO_SENSORS_THB2			(	0x0D,	RFmsgType.TEMP_HUM_BARO_SENSORS,0x02,	"BTHR918N, BTHR968"),
	
	RAIN_SENSORS_RAIN1					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x01,	"RGR126/682/918/928"),
	RAIN_SENSORS_RAIN2					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x02,	"PCR800"),
	RAIN_SENSORS_RAIN3					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x03,	"TFA/Honeywell TS906"),
	RAIN_SENSORS_RAIN4					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x04,	"UPM RG700"),
	RAIN_SENSORS_RAIN5					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x05,	"WS2300"),
	RAIN_SENSORS_RAIN6					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x06,	"La Crosse TX5"),
	RAIN_SENSORS_RAIN7					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x07,	"Alecto WS4500, Auriol H13726, Hama EWS1500, Meteoscan W155/W160,Ventus WS155"),
	RAIN_SENSORS_RAIN8					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x08,	"Davis"),
	RAIN_SENSORS_RAIN9					(	0x0B,	RFmsgType.RAIN_SENSORS,			0x09,	"Alecto ACH2010"),
	
	WIND_SENSORS_WIND1					(	0x10,	RFmsgType.WIND_SENSORS,			0x01,	"WTGR800"),
	WIND_SENSORS_WIND2					(	0x10,	RFmsgType.WIND_SENSORS,			0x02,	"WGR800"),
	WIND_SENSORS_WIND3					(	0x10,	RFmsgType.WIND_SENSORS,			0x03,	"STR918, WGR918, WGR928"),
	WIND_SENSORS_WIND4					(	0x10,	RFmsgType.WIND_SENSORS,			0x04,	"TFA/Honeywell TS805"),
	WIND_SENSORS_WIND5					(	0x10,	RFmsgType.WIND_SENSORS,			0x05,	"UPM WDS500, Davis"),
	WIND_SENSORS_WIND6					(	0x10,	RFmsgType.WIND_SENSORS,			0x06,	"WS2300"),
	WIND_SENSORS_WIND7					(	0x10,	RFmsgType.WIND_SENSORS,			0x07,	"Alecto WS4500, Auriol H13726, Hama EWS1500, Meteoscan W155/W160,Ventus WS155"),
	WIND_SENSORS_WIND8					(	0x10,	RFmsgType.WIND_SENSORS,			0x08,	"Alecto ACH2010"),
	
	UV_SENSORS_UV1						(	0x09,	RFmsgType.UV_SENSORS,			0x01,	"UVN128, UV138, Davis"),		
	UV_SENSORS_UV2						(	0x09,	RFmsgType.UV_SENSORS,			0x02,	"UVN800"),		
	UV_SENSORS_UV3						(	0x09,	RFmsgType.UV_SENSORS,			0x03,	"TFA"),
	
	DATE_TIME_SENSORS_DT1				(	0x0D,	RFmsgType.DATE_TIME_SENSORS,	0x01,	"RTGR328N, RTGR383"),
	
	CURRENT_SENSORS_ELEC1				(	0x0D,	RFmsgType.CURRENT_SENSORS,		0x01,	"CM113,  Electrisave, cent-a-meter"),
	
	ENERGY_SENSORS_ELEC2				(	0x11,	RFmsgType.ENERGY_SENSORS,		0x01,	"CM119/160"),	
	ENERGY_SENSORS_ELEC3				(	0x11,	RFmsgType.ENERGY_SENSORS,		0x02,	"CM180"),	
	
	CURRENT_ENERGY_SENSORS_ELEC4		(	0x13,	RFmsgType.CURRENT_ENERGY_SENSORS,0x01,	"CM180i"),
	
	POWER_SENSORS_ELEC5					(	0x0F,	RFmsgType.POWER_SENSORS,		0x01,	"Revolt"),
	
	WEIGHTING_SCALE_WEIGHT1				(	0x08,	RFmsgType.WEIGHTING_SCALE,		0x01,	"BWR101/102"),
	WEIGHTING_SCALE_WEIGHT2				(	0x08,	RFmsgType.WEIGHTING_SCALE,		0x02,	"GR101"),
	
	GAS_SENSORS_RESERVED				(	-1,	RFmsgType.GAS_SENSORS,			0x01,	"reserved"),
	
	WATER_SENSORS_RESERVED				(	-1,	RFmsgType.WATER_SENSORS,		0x01,	"reserved"),
	
	CARTELECTRONIC_TIC					(	0x15,	RFmsgType.CARTELECTRONIC,		0x01,	"TIC", 
			new String[] {"id1","id2","id3","id4","id5","contract_type","counter1_0","counter1_1","counter1_2","counter1_3","counter2_0","counter2_1","counter2_2","counter2_3","power_H","power_L","state","signal"}),
	CARTELECTRONIC_ENCODER				(	0x11,	RFmsgType.CARTELECTRONIC,		0x02,	"Encoder", 
			new String[] {"id1","id2","id3","id4","counter1_0","counter1_1","counter1_2","counter1_3","counter2_0","counter2_1","counter2_2","counter2_3","state","signal"}),
	CARTELECTORNIC_LINKY				(	0x15,	RFmsgType.CARTELECTRONIC,		0x03,	"Linky", 
			new String[] {"id1","id2","id3","id4","runidx_0","runidx_1","runidx_2","runidx_3","prodidx1_0","prodidx1_1","prodidx1_2","prodidx1_3","currentidx","av_voltage","power_H","power_L","state","signal"}),
	
	ASYNC_PORT_CONF						(	0x0B,	RFmsgType.ASYNC_PORT_CONF,		0x01,	"configure Async port")	,
	
	//ASYNC_TXRX
	
	RFXSENSOR_TEMP						(	0x07,	RFmsgType.RFXSENSOR,			0x00,	"RFXSensor temperature"),
	RFXSENSOR_AD						(	0x07,	RFmsgType.RFXSENSOR,			0x01,	"RFXSensor A/D"),
	RFXSENSOR_VOLTAGE					(	0x07,	RFmsgType.RFXSENSOR,			0x02,	"RFXSensor voltage"),
	RFXSENSOR_MESSAGE					(	0x07,	RFmsgType.RFXSENSOR,			0x03,	"RFXSensor message"),
	
	RFXMETER_NORMAL						(	0x0A,	RFmsgType.RFXMETER,				0x00,	"normal data packet"),
	RFXMETER_NEW_INTERVAL_TIME_SET		(	0x0A,	RFmsgType.RFXMETER,				0x01,	"new interval time set."),
	RFXMETER_CALIBRATE_VALUE			(	0x0A,	RFmsgType.RFXMETER,				0x02,	"calibrate value in <count> in µsec"),
	RFXMETER_NEW_ADDRESS_SET			(	0x0A,	RFmsgType.RFXMETER,				0x03,	"new address set"),
	RFXMETER_COUNTER_VALUE_RESET_MODE	(	0x0A,	RFmsgType.RFXMETER,				0x04,	"counter value reset mode within 5 seconds"),
	RFXMETER_COUNTER_VALUE_RESET_EXECUTED(	0x0A,	RFmsgType.RFXMETER,				0x0B,	"counter value reset executed"),
	RFXMETER_SET_INTERVAL_MODE			(	0x0A,	RFmsgType.RFXMETER,				0x0C,	"set interval mode within 5 seconds"),
	RFXMETER_CALIBRATION_MODE			(	0x0A,	RFmsgType.RFXMETER,				0x0D,	"calibration mode within 5 seconds"),
	RFXMETER_SET_ADDRESS_MODE			(	0x0A,	RFmsgType.RFXMETER,				0x0E,	"set address mode within 5 seconds"),
	RFXMETER_IDENTIFICATION_PACKET		(	0x0A,	RFmsgType.RFXMETER,				0x0F,	"identification packet"),
	
	FS20_FS20							(	0x09,	RFmsgType.FS20,					0x00,	"FS20"),
	FS20_FHT8V_VALVE					(	0x09,	RFmsgType.FS20,					0x01,	"FHT8V valve"),
	FS20_FHT80_DOOR_WINDOW_SENSOR		(	0x09,	RFmsgType.FS20,					0x02,	"FHT80 door/window sensor"),
	
	RAW_TXRX_TX1ST_PACKET				(	-1,	RFmsgType.RAW_TXRX,				0x00,	"RAW transmit 1st packet"),
	RAW_TXRX_TX2ND_PACKET				(	-1,	RFmsgType.RAW_TXRX,				0x00,	"RAW transmit 2nd packet"),
	RAW_TXRX_TX3RD_PACKET				(	-1,	RFmsgType.RAW_TXRX,				0x00,	"RAW transmit 3rd packet"),
	RAW_TXRX_TX4TH_PACKET				(	-1,	RFmsgType.RAW_TXRX,				0x00,	"RAW transmit 4th packet"),
	
	;
	RFmsgSubtype(int packetlength, RFmsgType msgType, int subtype, String description, String[] datamapping, Map<String,String> datacompute) {
		this.msgType = msgType;
		this.subtype = (short)subtype;
		this.description = description;
		this.packetlength=packetlength;
		this.dataMapping=datamapping;
		this.dataCompute = datacompute;
	}
	
	RFmsgSubtype(int packetlength, RFmsgType msgType, int subtype, String description) {
		this (packetlength,msgType,subtype,description,new String[] {},new HashMap<String,String>());
	}

	RFmsgSubtype(int packetlength, RFmsgType msgType, int subtype, String description, String[] datamapping) {
		this (packetlength,msgType,subtype,description,datamapping,new HashMap<String,String>());
	}

	RFmsgSubtype(int packetlength, RFmsgType msgType, int subtype, String description, Map<String,String> datacompute) {
		this (packetlength,msgType,subtype,description,new String[] {},datacompute);
	}
	
	private final int packetlength;
	private final RFmsgType msgType;
	private final short subtype;
	private final String description;
	private final String[] dataMapping;
	private final Map<String,String> dataCompute;
	
	public RFmsgType getMsgType() {
		return msgType;
	}
	public int get() {
		return subtype;
	}
	public String getDescription() {
		return description;
	}
	
	public Map<String,String> getCompute() {
		Map<String,String> result= new HashMap<String,String>();
		result.putAll(msgType.getCompute());
		result.putAll(dataCompute);
		return result;
	}
	
	public String[] getMapping() {
		if (dataMapping.length>0) return dataMapping;
		return msgType.getMapping();
	}
	
	public int getLength() {
		return packetlength;
	}
	
	public static RFmsgSubtype get(RFmsgType msgType, int subtype) {
		return get(msgType.getMsgType(), subtype);
	}
	
	public static RFmsgSubtype get(int type, int subtype) {
		for (RFmsgSubtype asubtype: RFmsgSubtype.values()) {
			if (asubtype.getMsgType().getMsgType() == type &&
				asubtype.get() == subtype) {
				return asubtype;
			}
		}
		return null;
	}
	
}
