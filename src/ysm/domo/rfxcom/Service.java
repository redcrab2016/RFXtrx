package ysm.domo.rfxcom;

import java.io.IOException;
import java.util.logging.Logger;

import ysm.domo.rfxcom.rfxtrx.Config;
import ysm.domo.rfxcom.rfxtrx.protocol.Protocol;
import ysm.domo.rfxcom.rfxtrx.protocol.ProtocolException;


public class Service {
	private static final Logger LOGGER = Logger.getLogger( Service.class.getName() );

	public static void echo(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		echo ("  ____  _______  ______ ___  __  __ ");
		echo (" |  _ \\|  ___\\ \\/ / ___/ _ \\|  \\/  |");
		echo (" | |_) | |_   \\  / |  | | | | |\\/| |");
		echo (" |  _ <|  _|  /  \\ |__| |_| | |  | |");
		echo (" |_| \\_\\_|   /_/\\_\\____\\___/|_|  |_|");
		echo ("                                    ");
		echo ("   >>RFXCOM Transceivers Service<<");
		Protocol proto=null;
		try {
			if (args.length >0) {
				LOGGER.info("Service configuration file: " + args[0] + "/config.properties");
				proto = new Protocol(new Config(args[0] + "/config.properties"));
			} else {
				throw new ProtocolException("Missing argument : provide path to folder that contains the file config.properties");
			}
			run(proto);
		} catch (ProtocolException | IOException e) {
			if (proto != null)
				proto.stop();
			e.printStackTrace();
			LOGGER.info("Service stopped with error");
		}
		echo("Bye...");
	}

	/**
	 * Execute the service , fault tolerant  (when exception occur re-init)
	 * @param proto
	 * @throws ProtocolException
	 */
	public static void run(Protocol proto) throws ProtocolException {
		LOGGER.info("Service started");
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
		LOGGER.info("Service stopped");
	}
}
