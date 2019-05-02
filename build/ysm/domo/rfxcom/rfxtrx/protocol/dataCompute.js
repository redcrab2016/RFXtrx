// In this script all 1st level interpret data from received message are available directly by its name
// this file is to defined useful function to be use inside dataCompute field of a message type/subtype
// in addition the variable "msgraw" represent the current MessageRaw object
function pulse() {
	return (pulseHigh*256+pulseLow) | 0;
}

function rssi() {
	return (signal & 0x00F0) >> 4;
}

function battery_level() {
	return (signal & 0x0F) | 0;
}

function channel1_10() {
	return (channel8_1 + (channel10_9 & 0x03)*256) | 0; 
}

function hcode() {
	if (msgraw.getPacketType() == 0x11){   // Lighting2
		if (msgraw.getPacketSutype() == 0x03) {// is Kambrook RF3672 (Australia)
			return String.fromCharCode(id1+65);
		} else {
			return null; // ignore this value
		}
	} else if (msgraw.getPacketType() == 0x10) { // lighting1
    	return String.fromCharCode(housecode);
	} else {
		return null; // ignore this value
	}
}

function command() {
	if (msgraw.getPacketType() == 0x10){ // Lighting1
		if (cmnd == 0x00) return "Off";
		if (cmnd == 0x01) return "On";
		if (cmnd == 0x02) return "Dim";
		if (cmnd == 0x03) return "Bright";
		if (cmnd == 0x04) return "Program";
		if (cmnd == 0x05) return "All/group Off";
		if (cmnd == 0x06) return "All/group/On";
		if (cmnd == 0x07) return "Chime";
		if (cmnd == 0x00FF) return "Illegal cmnd received";
	} else if (msgraw.getPacketType() == 0x11){ // Lighting2
		if (cmnd == 0x00) return "Off";
		if (cmnd == 0x01) return "On";
		if (cmnd == 0x02) return "set level";
		if (cmnd == 0x03) return "Group Off";
		if (cmnd == 0x04) return "Group On";
		if (cmnd == 0x05) return "Set group level";
	} else if (msgraw.getPacketType() == 0x12){ // Lighting3
		if (cmnd == 0x00) return "Bright";
		if (cmnd == 0x08) return "Dim";
		if (cmnd == 0x10) return "On";
		if (cmnd == 0x11) return "level 1";
		if (cmnd == 0x12) return "level 2";
		if (cmnd == 0x13) return "level 3";
		if (cmnd == 0x14) return "level 4";
		if (cmnd == 0x15) return "level 5";
		if (cmnd == 0x16) return "level 6";
		if (cmnd == 0x17) return "level 7";
		if (cmnd == 0x18) return "level 8";
		if (cmnd == 0x19) return "level 9";
		if (cmnd == 0x1A) return "Off";
		if (cmnd == 0x1C) return "Program";
	} else {
		return null; // ignore this value
	}
}

function id1_4() {
	if (msgraw.getPacketSutype() != 0x03) // not Kambrook RF3672 (Australia)
		return (id4 + id3 * 256 + id2 * 65536 + id1 * 16777216) | 0;
	else // is Kambrook RF3672 (Australia)
		return (id4 + id3 * 256 + id2 * 65536) | 0;		
}

function id1_3() {
	return (id3 + id2 * 256 + id1 * 65536)| 0;
}


function status_sec1() {
	if (status == 0x00) return "normal";
	if (status == 0x01) return "normal delayed";
	if (status == 0x02) return "alarm";
	if (status == 0x03) return "alarm delayed";
	if (status == 0x04) return "motion";
	if (status == 0x05) return "no motion";
	if (status == 0x06) return "panic";
	if (status == 0x07) return "end panic";
	if (status == 0x08) return "IR";
	if (status == 0x09) return "arm away";
	if (status == 0x0A) return "arm away delayed";
	if (status == 0x0B) return "arm home";
	if (status == 0x0C) return "arm home delayed";
	if (status == 0x0D) return "disarm";
	if (status == 0x10) return "light 1 off";
	if (status == 0x11) return "light 1 on";
	if (status == 0x12) return "light 2 off";
	if (status == 0x13) return "light 2 on";
	if (status == 0x14) return "dark detected";
	if (status == 0x15) return "light detected";
	if (status == 0x16) return "batlow SD18,CO18";
	if (status == 0x17) return "pair KD101/SA30/RM174RF";
	if (status == 0x80) return "normal + tamper";
	if (status == 0x81) return "normal delayed + tamper";
	if (status == 0x82) return "alarm + tamper";
	if (status == 0x83) return "alarm delayed + tamper";
	if (status == 0x84) return "motion + tamper";
	if (status == 0x85) return "no motion + tamper";	
	return null;
}
