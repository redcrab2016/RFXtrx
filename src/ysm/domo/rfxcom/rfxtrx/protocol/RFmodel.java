package ysm.domo.rfxcom.rfxtrx.protocol;

public enum RFmodel {
	RFXtrx315("RFXtrx315"),
	RFXtrx433("RFXtrx433"),
	RFXrec433("RFXrec433"),
	RFXtrx868X("RFXtrx868X"),
	RFXtrxIOT_433("RFXtrxIOT Receive 433"),
	RFXtrxIOT_868("RFXtrxIOT Receive 868"),
	Unknown("Unknown");
			
	RFmodel(String name) {
		this.name = name;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
}
