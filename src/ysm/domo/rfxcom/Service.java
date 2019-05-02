package ysm.domo.rfxcom;

import java.io.IOException;
import java.util.logging.Logger;

import ysm.domo.rfxcom.rfxtrx.Config;
import ysm.domo.rfxcom.rfxtrx.protocol.Protocol;
import ysm.domo.rfxcom.rfxtrx.protocol.ProtocolException;


public class Service {
	private static final Logger LOGGER = Logger.getLogger( Service.class.getName() );

	public static void main(String[] args) {
		Protocol proto=null;
		try {
			if (args.length >0) {
				proto = new Protocol(new Config(args[0] + "/config.properties"));
			} else {
				throw new ProtocolException("Missing argument : provide path to folder that contains the file config.properties");
			}
			run(proto);
		} catch (ProtocolException | IOException e) {
			if (proto != null)
				proto.stop();
			e.printStackTrace();
		}
	}

	/**
	 * Execute the service , fault tolerant  (when exception occur re-init)
	 * @param proto
	 * @throws ProtocolException
	 */
	public static void run(Protocol proto) throws ProtocolException {
		do {
			try {
				proto.loopInOut();
			} catch (ProtocolException e) {
				if (proto.shutdown()) {
					throw e;
				}
			}
			if (!proto.shutdown()) proto.init();
		} while (!proto.shutdown());
		LOGGER.info("End of service");
	}
}
