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
/*
Lighting 4

Chacon 54647
            le Ty St Sq  d1 d2 d3  d4  d5 d6
I   1 On :  09 13 00 85  15 15 55  01  a1 80 
I   1 Off:  09 13 00 8a  15 15 54  01  a1 70
I   2 On :  09 13 00 8c  15 45 55  01  a1 80 
I   2 Off:  09 13 00 8e  15 45 54  01  9f 80
I   3 On :  09 13 00 90  15 51 55  01  a3 80
I   3 Off:  09 13 00 97  15 51 54  01  9f 70
I   4 On:   09 13 00 99  15 54 55  01  a1 70 
I   4 Off:  09 13 00 9b  15 54 54  01  a1 70 

II  1 On :  09 13 00 9d  45 15 55  01  a1 80 
II  1 Off:  09 13 00 a0  45 15 54  01  a1 80 
II  2 On :  09 13 00 a2  45 45 55  01  a1 80 
II  2 Off:  09 13 00 a4  45 45 54  01  a1 70
II  3 On :  09 13 00 a7  45 51 55  01  a3 80 
II  3 Off:  09 13 00 a9  45 51 54  01  9f 80
II  4 On :  09 13 00 ab  45 54 55  01  a1 80
II  4 Off:  09 13 00 af  45 54 54  01  a1 80 

III 1 On :  09 13 00 b1  51 15 55  01  a1 80 
III 1 Off:  09 13 00 b3  51 15 54  01  9f 80 
III 2 On :  09 13 00 b5  51 45 55  01  a1 80 
III 2 Off:  09 13 00 b7  51 45 54  01  a1 70 
III 3 On :  09 13 00 b9  51 51 55  01  a1 80 
III 3 Off:  09 13 00 bb  51 51 54  01  a1 80
III 4 On :  09 13 00 bd  51 54 55  01  9f 80
III 4 Off:  09 13 00 bf  51 54 54  01  a1 80

IV  1 On :  09 13 00 c1  54 15 55  01  a3 80 
IV  1 Off:  09 13 00 c3  54 15 54  01  a1 80
IV  2 On :  09 13 00 c5  54 45 55  01  a3 80
IV  2 Off:  09 13 00 c7  54 45 54  01  a3 80 
IV  3 On :  09 13 00 c9  54 51 55  01  a3 80 
IV  3 Off:  09 13 00 cb  54 51 54  01  a1 80 
IV  4 On :  09 13 00 cd  54 54 55  01  a1 80
IV  4 Off:  09 13 00 d0  54 54 54  01  9f 80
  
*/

function chaconSwitch(data) {
	RFXCOM_generate(LIGHTING4, LIGHTING4_CHACON, data)
}

function chaconSwitch_I_1_On() {
	chaconSwitch([0x15, 0x15, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_I_1_Off() {
	chaconSwitch([0x15, 0x15, 0x54,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_I_2_On() {
	chaconSwitch([0x15, 0x45, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_I_2_Off() {
	chaconSwitch([0x15, 0x45, 0x54,  0x01,  0x9f, 0x80]);
}

function chaconSwitch_I_3_On() {
	chaconSwitch([0x15, 0x51, 0x55,  0x01,  0xa3, 0x80]);
}

function chaconSwitch_I_3_Off() {
	chaconSwitch([0x15, 0x51, 0x54,  0x01,  0x9f, 0x70]);
}

function chaconSwitch_I_4_On() {
	chaconSwitch([0x15, 0x54, 0x55,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_I_4_Off() {
	chaconSwitch([0x15, 0x54, 0x54,  0x01,  0xa1, 0x70]);
}



function chaconSwitch_II_1_On() {
	chaconSwitch([0x45, 0x15, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_II_1_Off() {
	chaconSwitch([0x45, 0x15, 0x54,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_II_2_On() {
	chaconSwitch([0x45, 0x45, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_II_2_Off() {
	chaconSwitch([0x45, 0x45, 0x54,  0x01,  0x9f, 0x80]);
}

function chaconSwitch_II_3_On() {
	chaconSwitch([0x45, 0x51, 0x55,  0x01,  0xa3, 0x80]);
}

function chaconSwitch_II_3_Off() {
	chaconSwitch([0x45, 0x51, 0x54,  0x01,  0x9f, 0x70]);
}

function chaconSwitch_II_4_On() {
	chaconSwitch([0x45, 0x54, 0x55,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_II_4_Off() {
	chaconSwitch([0x45, 0x54, 0x54,  0x01,  0xa1, 0x70]);
}



function chaconSwitch_III_1_On() {
	chaconSwitch([0x51, 0x15, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_III_1_Off() {
	chaconSwitch([0x51, 0x15, 0x54,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_III_2_On() {
	chaconSwitch([0x51, 0x45, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_III_2_Off() {
	chaconSwitch([0x51, 0x45, 0x54,  0x01,  0x9f, 0x80]);
}

function chaconSwitch_III_3_On() {
	chaconSwitch([0x51, 0x51, 0x55,  0x01,  0xa3, 0x80]);
}

function chaconSwitch_III_3_Off() {
	chaconSwitch([0x51, 0x51, 0x54,  0x01,  0x9f, 0x70]);
}

function chaconSwitch_III_4_On() {
	chaconSwitch([0x51, 0x54, 0x55,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_III_4_Off() {
	chaconSwitch([0x51, 0x54, 0x54,  0x01,  0xa1, 0x70]);
}




function chaconSwitch_IV_1_On() {
	chaconSwitch([0x54, 0x15, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_IV_1_Off() {
	chaconSwitch([0x54, 0x15, 0x54,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_IV_2_On() {
	chaconSwitch([0x54, 0x45, 0x55,  0x01,  0xa1, 0x80]);
}

function chaconSwitch_IV_2_Off() {
	chaconSwitch([0x54, 0x45, 0x54,  0x01,  0x9f, 0x80]);
}

function chaconSwitch_IV_3_On() {
	chaconSwitch([0x54, 0x51, 0x55,  0x01,  0xa3, 0x80]);
}

function chaconSwitch_IV_3_Off() {
	chaconSwitch([0x54, 0x51, 0x54,  0x01,  0x9f, 0x70]);
}

function chaconSwitch_IV_4_On() {
	chaconSwitch([0x54, 0x54, 0x55,  0x01,  0xa1, 0x70]);
}

function chaconSwitch_IV_4_Off() {
	chaconSwitch([0x54, 0x54, 0x54,  0x01,  0xa1, 0x70]);
}


function chacon_on(a1,a2) {
	eval('chaconSwitch_' + a1 + '_' + a2 + '_On()');
}

function chacon_off(a1,a2) {
	eval('chaconSwitch_' + a1 + '_' + a2 + '_Off()');
}

