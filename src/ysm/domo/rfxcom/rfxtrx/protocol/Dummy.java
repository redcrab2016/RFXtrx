package ysm.domo.rfxcom.rfxtrx.protocol;

public class Dummy {

	public static void main(String[] args) {
		byte b1;
		byte b2;
		short s1;
		short s2;
		
		s1 = 205;
		b1 = (byte)(s1 &0xff);

		s2 = (short)(0x00 << 24 | b1 & 0xff);
		System.out.println("S1 = " + String.valueOf(s1));
		System.out.println("b1 = " + String.valueOf(b1));		
		System.out.println("S2 = " + String.valueOf(s2));
	}

}
