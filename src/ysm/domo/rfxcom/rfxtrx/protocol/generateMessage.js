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
/**
 * Root function to generate the message
 * 'msg' variable is available and refer to a JSMessageBean java object, used for TX
 * msg.setType(t) , msg.setSubtype(st), msg.setData(arrayOfInteger)
 * @param type   message type
 * @param subtype message subtype
 * @param data  array of value 
 * @returns nothing
 */
function RFXCOM_generate(type, subtype, data) {
	msg.setType(type).setSubtype(subtype).setData(data);
}