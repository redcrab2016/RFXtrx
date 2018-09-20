package ysm.domo.rfxcom.rfxtrx.protocol;

public enum RFfrequency {
	RFXtrx315_315		(0x51,	RFmodel.RFXtrx315,		"315MHz"),
	RFXtrx315_310		(0x50,	RFmodel.RFXtrx315,		"310MHz"),
	RFXrec433_433		(0x52,	RFmodel.RFXrec433,		"433.92MHz"),
	RFXtrx433_433_92	(0x53,	RFmodel.RFXtrx433,		"433.92MHz"),
	RFXtrx433_433_42	(0x54,	RFmodel.RFXtrx433,		"433.42MHz"),
	RFXtrx433_434_50	(0x5F,	RFmodel.RFXtrx433,		"434.50MHz"),
	RFXtrx868X_868		(0x55,	RFmodel.RFXtrx868X,		"868MHz"),
	RFXtrxIOT_433		(0x5C,	RFmodel.RFXtrxIOT_433,	"433MHz"),
	RFXtrxIOT_868		(0x5D,	RFmodel.RFXtrxIOT_868,	"868MHz"),
	Unknown				(0x00,	RFmodel.Unknown,		"Unknown frequency")
	;
	RFfrequency(int freqId, RFmodel model, String description) {
	  this.freqId = (short)freqId;
	  this.model = model;
	  this.description = description;
	}
	
	private final short freqId;
	private final RFmodel model;
	private final String description;
	
	public short get() {
		return freqId;
	}
	
	public RFmodel getModel() {
		return model;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static RFfrequency getDefault(RFmodel model) {
		RFfrequency resultfreq = RFfrequency.Unknown;
		for (RFfrequency freq : RFfrequency.values()) {
			if (model == freq.getModel()) {
				resultfreq = freq;
				break;
			}
		}
		return resultfreq;
	}
}
