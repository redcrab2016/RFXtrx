/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

/**
 * @author edevaux
 *
 */
public enum RFtrxType {
	RFXtrx315_310		(0x50,	RFmodel.RFXtrx315,		RFfrequency.RFXtrx315_310,		"RFXtrx315 operating at 310MHz"),
	RFXtrx315			(0x51,	RFmodel.RFXtrx315,		RFfrequency.RFXtrx315_315,		"RFXtrx315 operating at 315MHz"),
	RFXrec433_92rx		(0x52,	RFmodel.RFXrec433,		RFfrequency.RFXrec433_433,		"RFXrec433 operating at 433.92MHz (receiver only)"), 
	RFXtrx433_92		(0x53,	RFmodel.RFXtrx433,		RFfrequency.RFXtrx433_433_92,	"RFXtrx433 operating at 433.92MHz"),
	RFXtrx433_42		(0x54,	RFmodel.RFXtrx433,		RFfrequency.RFXtrx433_433_42,	"RFXtrx433 operating at 433.42MHz"),
	RFXtrx868X			(0x55,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868MHz"), 
	RFXtrx868X_FSK		(0x56,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.00MHz FSK (obsolete)"), 
	RFXtrx868X_30		(0x57,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.30MHz  (obsolete)"),
	RFXtrx868X_30FSK	(0x58,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.30MHz FSK (obsolete)"), 
	RFXtrx868X_35		(0x59,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.35MHz  (obsolete)"),
	RFXtrx868X_35FSK	(0x5A,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.35MHz FSK (obsolete)"), 
	RFXtrx868X_95		(0x5B,	RFmodel.RFXtrx868X,		RFfrequency.RFXtrx868X_868,		"RFXtrx868X operating at 868.95MHz  (obsolete)"), 
	RFXtrxIOT_433_92	(0x5C,	RFmodel.RFXtrxIOT_433,	RFfrequency.RFXtrxIOT_433,		"RFXtrxIOT operating at 433.92MHz"), 
	RFXtrxIOT_868X		(0x5D,	RFmodel.RFXtrxIOT_868,	RFfrequency.RFXtrxIOT_868,		"RFXtrxIOT operating at 868MHz"), 
	RFXtrx433_50		(0x5F,	RFmodel.RFXrec433,		RFfrequency.RFXrec433_433,		"RFXtrx433 operating at 434.50MHz"),
	Unknown				(0x00,	RFmodel.Unknown,		RFfrequency.Unknown,			"Unknown device");
	
	RFtrxType(int type, RFmodel model, RFfrequency frequency, String desc) {
		txrxType = type;
		this.model = model; 
		this.frequency = frequency;
		description = desc;
	}
	
	
	private final int txrxType;
	private final String description;
	private final RFmodel model;
	private final RFfrequency frequency;
	
	public short getType() {
		return (short)txrxType;
	}
	
	public RFmodel getModel() {
		return model; 
	}
	
	public RFfrequency getFrequency() {
		return frequency;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static RFtrxType getType(int type) {
		for (RFtrxType devType : RFtrxType.values()) {
			if (devType.getType() == type) {
				return devType;
			}
		}
		return RFtrxType.Unknown;
	}
	
}
