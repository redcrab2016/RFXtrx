package ysm.domo.rfxcom;

import java.io.IOException;

import ysm.domo.rfxcom.rfxtrx.Config;
import ysm.domo.rfxcom.rfxtrx.io.MessageRaw;
import ysm.domo.rfxcom.rfxtrx.protocol.Protocol;
import ysm.domo.rfxcom.rfxtrx.protocol.ProtocolException;

public class Test {

	public static void main(String[] args) {

		Protocol proto=null;
		try {
			// please adapt the file path name to your appropriate config file name path.
			proto = new Protocol(new Config("/home/edevaux/projects/Raspberry/eclipse-workspace/RFXtrx/config.properties"));
			System.out.println(proto.getCurrentState().toString());
			MessageRaw msg;
			do {
				// catch all messages
				msg = proto.waitFor(-1, -1, -1, 0);
				System.out.println(msg.toString());
			} while(true);
			//proto.stop();
		} catch (ProtocolException | IOException e) {
			if (proto != null)
				proto.stop();
			e.printStackTrace();
		}
	}

}
