/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edevaux
 *
 */
public enum RFprotocol {
	// Possible protocols for RFXtrx315
	RFXtrx315_30	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 30"),
	RFXtrx315_31	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 31"),
	RFXtrx315_32	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 32"),
	RFXtrx315_33	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 33"),
	RFXtrx315_34	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 34"),
	RFXtrx315_35	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 35"),
	RFXtrx315_36	(false,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx315 36"),
	RFXtrx315_37	(true,	RFmodel.RFXtrx315,	RFprotocol.msg3,	RFprotocol.B7,	"undec on"),
	RFXtrx315_40	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B0,	"Unknown RFXtrx315 40"),
	RFXtrx315_41	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B1,	"Unknown RFXtrx315 41"),
	RFXtrx315_42	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B2,	"Unknown RFXtrx315 42"),
	RFXtrx315_43	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B3,	"Unknown RFXtrx315 43"),
	RFXtrx315_44	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B4,	"Unknown RFXtrx315 44"),
	RFXtrx315_45	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B5,	"Unknown RFXtrx315 45"),
	RFXtrx315_46	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B6,	"Unknown RFXtrx315 46"),
	RFXtrx315_47	(false,	RFmodel.RFXtrx315,	RFprotocol.msg4,	RFprotocol.B7,	"Unknown RFXtrx315 47"),
	RFXtrx315_50	(true,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B0,	"X10"),
	RFXtrx315_51	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B1,	"Unknown RFXtrx315 51"),
	RFXtrx315_52	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B2,	"Unknown RFXtrx315 52"),
	RFXtrx315_53	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B3,	"Unknown RFXtrx315 53"),
	RFXtrx315_54	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B4,	"Unknown RFXtrx315 54"),
	RFXtrx315_55	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B5,	"Unknown RFXtrx315 55"),
	RFXtrx315_56	(false,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B6,	"Unknown RFXtrx315 56"),
	RFXtrx315_57	(true,	RFmodel.RFXtrx315,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXtrx315_60	(true,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B0,	"Keeloq"),
	RFXtrx315_61	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B1,	"Unknown RFXtrx315 61"),
	RFXtrx315_62	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrx315 62"),
	RFXtrx315_63	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrx315 63"),
	RFXtrx315_64	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrx315 64"),
	RFXtrx315_65	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B5,	"Unknown RFXtrx315 65"),
	RFXtrx315_66	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B6,	"Unknown RFXtrx315 66"),
	RFXtrx315_67	(false,	RFmodel.RFXtrx315,	RFprotocol.msg6,	RFprotocol.B7,	"Unknown RFXtrx315 67"),
	// Possible protocols for RFXtrx433
	RFXtrx433_30	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B0,	"AE Blyss"),
	RFXtrx433_31	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B1,	"Rubicson,Alecto,Banggood"),
	RFXtrx433_32	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B2,	"FineOffset,Viking"),
	RFXtrx433_33	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B3,	"Lighting4"),
	RFXtrx433_34	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B4,	"RSL,Revolt"),
	RFXtrx433_35	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B5,	"Byron SX,SelectPlus"),
	RFXtrx433_36	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B6,	"Imagintronix,Opus "),
	RFXtrx433_37	(true,	RFmodel.RFXtrx433,	RFprotocol.msg3,	RFprotocol.B7,	"undec on"),
	RFXtrx433_40	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B0,	"Mertik"),
	RFXtrx433_41	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B1,	"AD LightwaveRF"),
	RFXtrx433_42	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B2,	"Hideki,TFA,Cresta,UPM"),
	RFXtrx433_43	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B3,	"La Crosse"),
	RFXtrx433_44	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B4,	"Legrand CAD"),
	RFXtrx433_45	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B5,	"Unknown RFXtrx433 45"),
	RFXtrx433_46	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B6,	"BlindsT0"),
	RFXtrx433_47	(true,	RFmodel.RFXtrx433,	RFprotocol.msg4,	RFprotocol.B7,	"BlindsT1/T2/T3/T4"),
	RFXtrx433_50	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B0,	"X10"),
	RFXtrx433_51	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B1,	"ARC"),
	RFXtrx433_52	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B2,	"AC"),
	RFXtrx433_53	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B3,	"HomeEasy EU"),
	RFXtrx433_54	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B4,	"Meiantech,Atlantic"),
	RFXtrx433_55	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B5,	"Oregon Scientific"),
	RFXtrx433_56	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B6,	"ATI/cartelectronic"),
	RFXtrx433_57	(true,	RFmodel.RFXtrx433,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXtrx433_60	(true,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B0,	"Keeloq"),
	RFXtrx433_61	(true,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B1,	"HomeConfort"),
	RFXtrx433_62	(false,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrx433 62"),
	RFXtrx433_63	(false,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrx433 63"),
	RFXtrx433_64	(false,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrx433 64"),
	RFXtrx433_65	(false,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B5,	"Unknown RFXtrx433 65"),
	RFXtrx433_66	(true,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B6,	"MCZ"),
	RFXtrx433_67	(true,	RFmodel.RFXtrx433,	RFprotocol.msg6,	RFprotocol.B7,	"FunkBus"),
	// Possible protocols for RFXrec433 (assumption to be the same as RFXtrx433)
	RFXrec433_30	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B0,	"AE Blyss"),
	RFXrec433_31	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B1,	"Rubicson,Alecto,Banggood"),
	RFXrec433_32	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B2,	"FineOffset,Viking"),
	RFXrec433_33	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B3,	"Lighting4"),
	RFXrec433_34	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B4,	"RSL,Revolt"),
	RFXrec433_35	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B5,	"Byron SX,SelectPlus"),
	RFXrec433_36	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B6,	"Imagintronix,Opus "),
	RFXrec433_37	(true,	RFmodel.RFXrec433,	RFprotocol.msg3,	RFprotocol.B7,	"undec on"),
	RFXrec433_40	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B0,	"Mertik"),
	RFXrec433_41	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B1,	"AD LightwaveRF"),
	RFXrec433_42	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B2,	"Hideki,TFA,Cresta,UPM"),
	RFXrec433_43	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B3,	"La Crosse"),
	RFXrec433_44	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B4,	"Legrand CAD"),
	RFXrec433_45	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B5,	"Unknown RFXtrx433 45"),
	RFXrec433_46	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B6,	"BlindsT0"),
	RFXrec433_47	(true,	RFmodel.RFXrec433,	RFprotocol.msg4,	RFprotocol.B7,	"BlindsT1/T2/T3/T4"),
	RFXrec433_50	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B0,	"X10"),
	RFXrec433_51	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B1,	"ARC"),
	RFXrec433_52	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B2,	"AC"),
	RFXrec433_53	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B3,	"HomeEasy EU"),
	RFXrec433_54	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B4,	"Meiantech,Atlantic"),
	RFXrec433_55	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B5,	"Oregon Scientific"),
	RFXrec433_56	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B6,	"ATI/cartelectronic"),
	RFXrec433_57	(true,	RFmodel.RFXrec433,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXrec433_60	(true,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B0,	"Keeloq"),
	RFXrec433_61	(true,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B1,	"HomeConfort"),
	RFXrec433_62	(false,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrx433 62"),
	RFXrec433_63	(false,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrx433 63"),
	RFXrec433_64	(false,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrx433 64"),
	RFXrec433_65	(false,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B5,	"Unknown RFXtrx433 65"),
	RFXrec433_66	(true,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B6,	"MCZ"),
	RFXrec433_67	(true,	RFmodel.RFXrec433,	RFprotocol.msg6,	RFprotocol.B7,	"FunkBus"),
	// Possible protocols for RFXtrx868X
	RFXtrx868X_30	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrx868X 30"),
	RFXtrx868X_31	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B1,	"Davis AU"),
	RFXtrx868X_32	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B2,	"Davis US"),
	RFXtrx868X_33	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B3,	"Davis EU"),
	RFXtrx868X_34	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B4,	"Unknown RFXtrx868X 34"),
	RFXtrx868X_35	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B5,	"La Crosse"),
	RFXtrx868X_36	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B6,	"Alecto"),
	RFXtrx868X_37	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg3,	RFprotocol.B7,	"undec on"),
	RFXtrx868X_40	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B0,	"Edisio"),
	RFXtrx868X_41	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B1,	"Unknown RFXtrx868X 41"),
	RFXtrx868X_42	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B2,	"Unknown RFXtrx868X 42"),
	RFXtrx868X_43	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B3,	"Unknown RFXtrx868X 43"),
	RFXtrx868X_44	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B4,	"FS20"),
	RFXtrx868X_45	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B5,	"ProGuard"),
	RFXtrx868X_46	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B6,	"Unknown RFXtrx868X 46"),
	RFXtrx868X_47	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg4,	RFprotocol.B7,	"Unknown RFXtrx868X 47"),
	RFXtrx868X_50	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B0,	"Unknown RFXtrx868X 50"),
	RFXtrx868X_51	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B1,	"Unknown RFXtrx868X 51"),
	RFXtrx868X_52	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B2,	"Unknown RFXtrx868X 52"),
	RFXtrx868X_53	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B3,	"Unknown RFXtrx868X 53"),
	RFXtrx868X_54	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B4,	"Unknown RFXtrx868X 54"),
	RFXtrx868X_55	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B5,	"Unknown RFXtrx868X 55"),
	RFXtrx868X_56	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B6,	"Meiantech,Atlantic"),
	RFXtrx868X_57	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXtrx868X_60	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B0,	"Keeloq"),
	RFXtrx868X_61	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B1,	"Unknown RFXtrx868X 61"),
	RFXtrx868X_62	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrx868X 62"),
	RFXtrx868X_63	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrx868X 63"),
	RFXtrx868X_64	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrx868X 64"),
	RFXtrx868X_65	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B5,	"Unknown RFXtrx868X 65"),
	RFXtrx868X_66	(false,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B6,	"Unknown RFXtrx868X 66"),
	RFXtrx868X_67	(true,	RFmodel.RFXtrx868X,	RFprotocol.msg6,	RFprotocol.B7,	"Itho CVE RFT"),
	// Possible protocols for RFXtrxIOT_433
	RFXtrxIOT433_30	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrxIOT_433 30"),
	RFXtrxIOT433_31	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B1,	"Unknown RFXtrxIOT_433 31"),
	RFXtrxIOT433_32	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B2,	"Unknown RFXtrxIOT_433 32"),
	RFXtrxIOT433_33	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B3,	"Unknown RFXtrxIOT_433 33"),
	RFXtrxIOT433_34	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B4,	"Unknown RFXtrxIOT_433 34"),
	RFXtrxIOT433_35	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B5,	"Unknown RFXtrxIOT_433 35"),
	RFXtrxIOT433_36	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B6,	"Unknown RFXtrxIOT_433 36"),
	RFXtrxIOT433_37	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg3,	RFprotocol.B7,	"Unknown RFXtrxIOT_433 37"),
	RFXtrxIOT433_40	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B0,	"Unknown RFXtrxIOT_433 40"),
	RFXtrxIOT433_41	(true,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B1,	"AD LightwaveRF"),
	RFXtrxIOT433_42	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B2,	"Unknown RFXtrxIOT_433 42"),
	RFXtrxIOT433_43	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B3,	"Unknown RFXtrxIOT_433 43"),
	RFXtrxIOT433_44	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B4,	"Unknown RFXtrxIOT_433 44"),
	RFXtrxIOT433_45	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B5,	"Unknown RFXtrxIOT_433 45"),
	RFXtrxIOT433_46	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B6,	"Unknown RFXtrxIOT_433 46"),
	RFXtrxIOT433_47	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg4,	RFprotocol.B7,	"Unknown RFXtrxIOT_433 47"),
	RFXtrxIOT433_50	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B0,	"Unknown RFXtrxIOT_433 50"),
	RFXtrxIOT433_51	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B1,	"Unknown RFXtrxIOT_433 51"),
	RFXtrxIOT433_52	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B2,	"Unknown RFXtrxIOT_433 52"),
	RFXtrxIOT433_53	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B3,	"Unknown RFXtrxIOT_433 53"),
	RFXtrxIOT433_54	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B4,	"Unknown RFXtrxIOT_433 54"),
	RFXtrxIOT433_55	(true,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B5,	"Keeloq"),
	RFXtrxIOT433_56	(true,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B6,	"Meiantech,Atlantic"),
	RFXtrxIOT433_57	(true,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXtrxIOT433_60	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B0,	"Unknown RFXtrxIOT_433 60"),
	RFXtrxIOT433_61	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B1,	"Unknown RFXtrxIOT_433 61"),
	RFXtrxIOT433_62	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrxIOT_433 62"),
	RFXtrxIOT433_63	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrxIOT_433 63"),
	RFXtrxIOT433_64	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrxIOT_433 64"),
	RFXtrxIOT433_65	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B5,	"Unknown RFXtrxIOT_433 65"),
	RFXtrxIOT433_66	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B6,	"Unknown RFXtrxIOT_433 66"),
	RFXtrxIOT433_67	(false,	RFmodel.RFXtrxIOT_433,	RFprotocol.msg6,	RFprotocol.B7,	"Unknown RFXtrxIOT_433 67"),
	// Possible protocols for RFXtrxIOT_868
	RFXtrxIOT868_30	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B0,	"Unknown RFXtrxIOT_868 30"),
	RFXtrxIOT868_31	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B1,	"Davis AU"),
	RFXtrxIOT868_32	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B2,	"Davis US"),
	RFXtrxIOT868_33	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B3,	"Davis EU"),
	RFXtrxIOT868_34	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B4,	"Unknown RFXtrxIOT_868 34"),
	RFXtrxIOT868_35	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B5,	"La Crosse"),
	RFXtrxIOT868_36	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B6,	"Alecto"),
	RFXtrxIOT868_37	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg3,	RFprotocol.B7,	"Unknown RFXtrxIOT_868 37"),
	RFXtrxIOT868_40	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B0,	"Edisio"),
	RFXtrxIOT868_41	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B1,	"AD LightwaveRF"),
	RFXtrxIOT868_42	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B2,	"FS20"),
	RFXtrxIOT868_43	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B3,	"Unknown RFXtrxIOT_868 43"),
	RFXtrxIOT868_44	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B4,	"Unknown RFXtrxIOT_868 44"),
	RFXtrxIOT868_45	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B5,	"Unknown RFXtrxIOT_868 45"),
	RFXtrxIOT868_46	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B6,	"Unknown RFXtrxIOT_868 46"),
	RFXtrxIOT868_47	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg4,	RFprotocol.B7,	"Unknown RFXtrxIOT_868 47"),
	RFXtrxIOT868_50	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B0,	"Unknown RFXtrxIOT_868 50"),
	RFXtrxIOT868_51	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B1,	"Unknown RFXtrxIOT_868 51"),
	RFXtrxIOT868_52	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B2,	"Unknown RFXtrxIOT_868 52"),
	RFXtrxIOT868_53	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B3,	"Unknown RFXtrxIOT_868 53"),
	RFXtrxIOT868_54	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B4,	"ProGuard"),
	RFXtrxIOT868_55	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B5,	"Keeloq"),
	RFXtrxIOT868_56	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B6,	"Meiantech,Atlantic"),
	RFXtrxIOT868_57	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg5,	RFprotocol.B7,	"Visonic"),
	RFXtrxIOT868_60	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B0,	"Unknown RFXtrxIOT_868 60"),
	RFXtrxIOT868_61	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B1,	"Unknown RFXtrxIOT_868 61"),
	RFXtrxIOT868_62	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B2,	"Unknown RFXtrxIOT_868 62"),
	RFXtrxIOT868_63	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B3,	"Unknown RFXtrxIOT_868 63"),
	RFXtrxIOT868_64	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B4,	"Unknown RFXtrxIOT_868 64"),
	RFXtrxIOT868_65	(false,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B5,	"Honeywell Chime"),
	RFXtrxIOT868_66	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B6,	"Itho CVE ECO RFT"),
	RFXtrxIOT868_67	(true,	RFmodel.RFXtrxIOT_868,	RFprotocol.msg6,	RFprotocol.B7,	"Itho CVE RFT");
	
	RFprotocol( boolean valid, RFmodel model,int msgIdx, int orMask, String name) {
		this.msgIdx = msgIdx;
		this.orMask = (short)(orMask & 0xFF);
		this.andMask = (short)((~this.orMask) & 0xFF);
		this.name = name;
		this.model = model;
		this.valid = valid;
	}
	private final static int B0=0x01;
	private final static int B1=0x02;
	private final static int B2=0x04;
	private final static int B3=0x08;
	private final static int B4=0x10;
	private final static int B5=0x20;
	private final static int B6=0x40;
	private final static int B7=0x80;
	
	private final static int msg3=3;
	private final static int msg4=4;
	private final static int msg5=5;
	private final static int msg6=6;
	
	private final boolean valid;
	private final int msgIdx;
	private final short orMask;
	private final short andMask;
	private final String name;
	private final RFmodel model;
	
	public int  getMsgIdx() {
		return msgIdx;
	}
	
	public short getOrMask() {
		return orMask;
	}
	
	public short getAndMask() {
		return andMask;
	}
	
	public String getName() {
		return name;
	}
	
	public RFmodel getModel() {
		return model;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public static RFprotocol getProtocol(RFmodel model, String labelProto) {
		RFprotocol proto = null;
		for (RFprotocol aProto : RFprotocol.values() ) {
			if (aProto.getModel() == model && aProto.getName().toUpperCase().indexOf(labelProto.toUpperCase()) >=0 ) {
				proto = aProto;
				break;
			}
		}
		return proto;
	}
	
	public static List<RFprotocol> getProtocols(RFmodel model, String[] labelsProto) {
		List<RFprotocol> protoLst = new ArrayList<RFprotocol>();
		for (String aLabel : labelsProto) {
			RFprotocol proto = getProtocol(model, aLabel);
			if (proto != null) protoLst.add(proto);
		}
		return protoLst;
	}
	
	
	public static List<RFprotocol> getProtocols(MessageRaw msg) throws MessageException {
		if ( msg == null ) throw new MessageException("Null message.");
		if (  msg.getPacketType() == 1 && 
			  msg.getPacketSubtype() == 0 &&
			  msg.getPacketData(0) == 2 ) { // Message resulting of getSatus request
			List<RFprotocol> protocols = new ArrayList<RFprotocol>();
			short[] packetData = msg.getPacketData();
			RFmodel model = RFtrxType.getType(packetData[1]).getModel();
			for (RFprotocol proto: RFprotocol.values()) {
				int idx = proto.getMsgIdx();
				int orMask = proto.getOrMask();
				if (	proto.getModel() == model && 
						(packetData[idx] & orMask & 0xFF) >0) {
					protocols.add(proto);
				}
			}
			return protocols;
		} else {
			throw new MessageException("Incorrect Message to retreive protocol list, Expect getstatus answer message");
		}
	}
	
	
	public static MessageRaw setProtocols(MessageRaw msg, RFmodel model, String[] labelsProto) throws MessageException {
		List<RFprotocol> protoLst = getProtocols(model, labelsProto);
		return setProtocols(msg, model, protoLst);
		
	}
	
	public static MessageRaw setProtocols(MessageRaw msg, RFmodel model, List<RFprotocol> lstProto) throws MessageException {
		if ( msg.getPacketType()==0 && msg.getPacketSubtype()==0 && msg.getPacketData(0)==2) {
			short[] packetData = msg.getPacketData();
			packetData[RFprotocol.msg3]=0;
			packetData[RFprotocol.msg4]=0;
			packetData[RFprotocol.msg5]=0;
			packetData[RFprotocol.msg6]=0;
			for (RFprotocol aProto : lstProto) {
				if  (aProto.getModel() == model) {
					int idx = aProto.getMsgIdx();
					int orMask = aProto.getOrMask();
					packetData[idx] |= orMask;
				}
			}
			msg.setPacketData(packetData);
			return msg;
		} else {
			throw new MessageException("Incorrect Message to set protocol list, Expect setStatus message.");
		}
	}
	
	public static short[] getProtocolData( List<RFprotocol> lstProto) {
		short[] protoData = new short[4];
		protoData[0]=0;
		protoData[1]=0;
		protoData[2]=0;
		protoData[3]=0;
		for (RFprotocol aProto : lstProto) {
			int idx = aProto.getMsgIdx();
			int orMask = aProto.getOrMask();
			protoData[idx-3] |= orMask;
		}
		return protoData;
		
	}
	
}
