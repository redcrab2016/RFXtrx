package ysm.domo.rfxcom;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
				String configfile = args[0] + "/config.properties";
				Config config = Config.getInstance();
				config.init(configfile);
				Logger logger = Logger.getLogger("");
				for (Handler loghandler: logger.getHandlers()) {
					loghandler.setFormatter(new SimpleFormatter() {
                        
                            private String format =  null;
                            private final Date dat = new Date();

                                @Override
                                synchronized public String format(LogRecord record) {
                                        if (format == null)
                                                format = Config.getInstance().get("rfxtrx.service.log.format", "%1$tc : %3$s : %2$s : %4$s : %5$s%6$s%n");
                                dat.setTime(record.getMillis());
                                String source;
                                if (record.getSourceClassName() != null) {
                                    source = record.getSourceClassName();
                                    if (record.getSourceMethodName() != null) {
                                       source = source.substring(source.lastIndexOf('.')+1);
                                       source += " " + record.getSourceMethodName();
                                    }
                                } else {
                                    source = record.getLoggerName();
                                }
                                String message = formatMessage(record);
                                String throwable = "";
                                if (record.getThrown() != null) {
                                    StringWriter sw = new StringWriter();
                                    PrintWriter pw = new PrintWriter(sw);
                                    pw.println();
                                    record.getThrown().printStackTrace(pw);
                                    pw.close();
                                    throwable = sw.toString();
                                }
                                return String.format(format,
                                                     dat,
                                                     source,
                                                     record.getLoggerName(),
                                                     record.getLevel().getLocalizedName(),
                                                     message,
                                                     throwable);
                                }
					});
				}

				LOGGER.info("Service configuration file: " + configfile);
				proto = new Protocol(config);
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
