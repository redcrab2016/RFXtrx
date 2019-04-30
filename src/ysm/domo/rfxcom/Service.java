package ysm.domo.rfxcom;

import java.io.IOException;

import ysm.domo.rfxcom.rfxtrx.Config;
import ysm.domo.rfxcom.rfxtrx.protocol.Protocol;
import ysm.domo.rfxcom.rfxtrx.protocol.ProtocolException;

public class Service {

	public static void main(String[] args) {
		Protocol proto=null;
		try {
			if (args.length >0) {
				proto = new Protocol(new Config(args[0] + "/config.properties"));
			} else {
				throw new ProtocolException("Missing argument : provide path to folder that contains the file config.properties");
			}
			proto.loopInOut();
		} catch (ProtocolException | IOException e) {
			if (proto != null)
				proto.stop();
			e.printStackTrace();
		}
	}
}
