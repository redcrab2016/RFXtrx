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

public enum RFmodel {
	RFXtrx315("RFXtrx315",false),
	RFXtrx433("RFXtrx433", false),
	RFXrec433("RFXrec433",false ),
	RFXtrx868X("RFXtrx868X", true),
	RFXtrxIOT_433("RFXtrxIOT Receive 433", true),
	RFXtrxIOT_868("RFXtrxIOT Receive 868", true),
	Unknown("Unknown",false);
			
	RFmodel(String name, boolean xmitpwr) {
		this.name = name;
		this.xmitpwr = xmitpwr;
	}
	
	private final String name;
	private final boolean xmitpwr;
	
	public String getName() {
		return name;
	}
	
	public boolean isXmitpwr() {
		return xmitpwr;
	}
}
