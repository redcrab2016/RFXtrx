package ysm.domo.rfxcom.rfxtrx.protocol;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			int packetType = 0;
			int packetSubtype=0;
			int sequenceNumber = 0;
			short[] packetData= new short[10];
			for (int i = 0 ; i < 10; i++) {
				packetData[i]=0;
			}
			MessageRaw msgReset = new MessageRaw(packetType, packetSubtype, sequenceNumber, packetData);
			MessageRaw msgGetStatus = new MessageRaw(msgReset);
			msgGetStatus.setSequenceNumber(1);
			packetData[0]=2;
			msgGetStatus.setPacketData(packetData);
			MessageRaw msgCheckRfx = new MessageRaw(msgGetStatus);
			msgCheckRfx.setSequenceNumber(2);
			packetData[0]=7;
			msgCheckRfx.setPacketData(packetData);

			Transport trans = new Transport("/home/edevaux/projects/Raspberry/remttyUSB");
			System.out.println("Send         :" + msgReset.toString());
			trans.sendMessage(msgReset);
			for (int i=0;i < 10; i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// do nothing
				}
				trans.receiveMessage(false);
			}
			System.out.println("Send         :" + msgGetStatus.toString());
			trans.sendMessage(msgGetStatus);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// do nothing
			}
			MessageRaw status = trans.receiveMessage();
			System.out.println("Status Answer:"+ status.toString());
			System.out.println("Send         :" + msgCheckRfx.toString());
			trans.sendMessage(msgCheckRfx);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// do nothing
			}
			MessageRaw check = trans.receiveMessage();
			System.out.println("Check Answer :"+ check.toString());
			
		} catch (TransportException e) {
			e.printStackTrace();
		} catch (MessageException e) {
			
			e.printStackTrace();
		}

	}

}
