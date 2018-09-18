/**
 * 
 */
package ysm.domo.rfxcom.rfxtrx.protocol;

import java.util.List;

/**
 * @author edevaux
 *
 */
public class RFStatus {

	private int RFXtrxType;
	private int FWVersion;
	private int HWMajorVersion;
	private int HWMinorVersion;
	private int xmitPower;
	private int FWType;
	private int noiseLevel;
	private List<RFprotocol> enabledProtocols;
	
	
	/**
	 * 
	 */
	public RFStatus() {
		// TODO Auto-generated constructor stub
	}

}
