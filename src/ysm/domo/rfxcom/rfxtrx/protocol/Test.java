package ysm.domo.rfxcom.rfxtrx.protocol;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {

		Protocol proto=null;
		try {
			proto = new Protocol("/home/edevaux/projects/Raspberry/remttyUSB");
			proto.start();
			String result = proto.controlReset();
			System.out.println(result);
			System.out.println(proto.getCurrentState().toString());
			proto.stop();
		} catch (ProtocolException e) {
			if (proto != null)
				proto.stop();
			e.printStackTrace();
		}

		/*
		try {
			
			MessageRaw msgReset = new MessageRaw(	0, 0, 0, new short[] {0,0,0,0,0,0,0,0,0,0});
			MessageRaw msgGetStatus = new MessageRaw(	0, 0, 1, new short[] {2,0,0,0,0,0,0,0,0,0});
			MessageRaw msgCheckRfx = new MessageRaw(	0, 0, 2, new short[] {7,0,0,0,0,0,0,0,0,0});

			Transport trans = new Transport("/home/edevaux/projects/Raspberry/remttyUSB");
			trans.start();
			
			System.out.println("Send         :" + msgReset.toString());
			trans.sendMessage(msgReset);
			for (int i=0;i < 10; i++) {
				pause(200);
				trans.receiveMessage(false);
			}
			System.out.println("Send         :" + msgGetStatus.toString());
			trans.sendMessage(msgGetStatus);
			MessageRaw status = trans.receiveMessage(5000);
			System.out.println("Status Answer:"+ status.toString());
			
			System.out.println("Send         :" + msgCheckRfx.toString());
			trans.sendMessage(msgCheckRfx);
			MessageRaw check = trans.receiveMessage();
			System.out.println("Check Answer :"+ check.toString());
			
			trans.stop();
		} catch (TransportException e) {
			e.printStackTrace();
		} catch (MessageException e) {
			
			e.printStackTrace();
		}
		*/

	}

}
