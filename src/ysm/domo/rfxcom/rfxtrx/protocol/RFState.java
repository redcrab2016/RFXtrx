/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.util.List;

/**
 * @author edevaux
 *
 */
public class RFState {

	private RFtrxType rfxtrxType;
	private RFfrequency rfFrequency;
	private int FWVersion;
	private int HWMajorVersion;
	private int HWMinorVersion;
	private String HWVersion;
	private RFxmitpwr xmitPower;
	private RFfirmwareType FWType;
	private int noiseLevel;
	private List<RFprotocol> enabledProtocols;
	private MessageRaw stateMessage;
	
	/**
	 * 
	 */
	public RFState() {
		
	}
	
	public RFState(MessageRaw msg) throws MessageException {
		init(msg);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb
//		.append("State Message: ").append(stateMessage.toString()).append("\n")
		.append("RFtrxType         : ").append(rfxtrxType.getDescription()).append("\n")
		.append("Selected Frequency: ").append(rfFrequency.getDescription()).append("\n")
		.append("Hardware Version  : ").append(HWVersion).append("\n")
		.append("Firmware Type     : ").append(FWType.getDescription()).append("\n")
		.append("Firmware Version  : ").append(FWVersion).append("\n")
		.append("TX power          : ").append(xmitPower.getDescription()).append("\n");
		for (RFprotocol proto: enabledProtocols ) {
		sb
		.append("RX Protocol       : ").append(proto.getName()).append("\n");
		}
		
		return sb.toString();
	}
	
	public void init(MessageRaw msg) throws MessageException {
		if (msg == null ) throw new MessageException("Null message");
		stateMessage = new MessageRaw(msg);
		if (	msg.getPacketType()		== 0x01 &&
				msg.getPacketSubtype()	== 0x00 &&
				(msg.getPacketData(0)	== 0x02 || 
				 msg.getPacketData(0)   == 0x03 )) { // answer message of getStatus/setMode
			rfxtrxType = RFtrxType.getType(msg.getPacketData(1));
			rfFrequency = rfxtrxType.getFrequency();
			FWVersion = msg.getPacketData(2)+1000;
			HWMajorVersion = msg.getPacketData(7);
			HWMinorVersion = msg.getPacketData(8);
			HWVersion = "" + HWMajorVersion + "." + HWMinorVersion;
			xmitPower = RFxmitpwr.get(msg.getPacketData(9));
			FWType = RFfirmwareType.get(msg.getPacketData(10));
			noiseLevel = msg.getPacketData(11);
			enabledProtocols = RFprotocol.getProtocols(msg);
			
		} else {
			throw new MessageException("Answer message of GetStatus expected.");
		}
	}

	public short[] getSetModePacketData() {
		short[] protoData = RFprotocol.getProtocolData(enabledProtocols);
		return new short[] 
				{	0x03, // cmnd : set mode
					rfFrequency.get(), // frequency
					xmitPower.get(), // power
					protoData[0], // protocol msg3
					protoData[1], // protocol msg4
					protoData[2], // protocol msg5
					protoData[3], // protocol msg6
					0,  // msg7 // RFU
					0,  // msg8 // RFU
					0   // msg9 // RFU
				};
	}
	
	/**
	 * @return the xmitPower
	 */
	public RFxmitpwr getXmitPower() {
		return xmitPower;
	}

	/**
	 * @param xmitPower the xmitPower to set
	 */
	public void setXmitPower(RFxmitpwr xmitPower) {
		this.xmitPower = xmitPower;
	}

	/**
	 * @return the enabledProtocols
	 */
	public List<RFprotocol> getEnabledProtocols() {
		return enabledProtocols;
	}

	/**
	 * @param enabledProtocols the enabledProtocols to set
	 */
	public void setEnabledProtocols(List<RFprotocol> enabledProtocols) {
		this.enabledProtocols = enabledProtocols;
	}

	/**
	 * @return the rfxtrxType
	 */
	public RFtrxType getRfxtrxType() {
		return rfxtrxType;
	}

	/**
	 * @return the fWVersion
	 */
	public int getFWVersion() {
		return FWVersion;
	}

	/**
	 * @return the hWMajorVersion
	 */
	public int getHWMajorVersion() {
		return HWMajorVersion;
	}

	/**
	 * @return the hWMinorVersion
	 */
	public int getHWMinorVersion() {
		return HWMinorVersion;
	}

	/**
	 * @return the hWVersion
	 */
	public String getHWVersion() {
		return HWVersion;
	}

	/**
	 * @return the fWType
	 */
	public RFfirmwareType getFWType() {
		return FWType;
	}

	/**
	 * @return the noiseLevel
	 */
	public int getNoiseLevel() {
		return noiseLevel;
	}

	/**
	 * @return the rfFrequency
	 */
	public RFfrequency getRfFrequency() {
		return rfFrequency;
	}

	/**
	 * @param rfFrequency the rfFrequency to set
	 */
	public void setRfFrequency(RFfrequency rfFrequency) {
		this.rfFrequency = rfFrequency;
	}

	


}
