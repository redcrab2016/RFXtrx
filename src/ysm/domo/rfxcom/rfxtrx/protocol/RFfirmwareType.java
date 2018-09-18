package ysm.domo.rfxcom.rfxtrx.protocol;

public enum RFfirmwareType {
	TYPE1rec	(0x00, "Type1 RFXrec receive only firmaware"),
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
