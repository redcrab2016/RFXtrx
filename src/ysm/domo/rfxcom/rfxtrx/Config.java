/**
 * 
 */
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
package ysm.domo.rfxcom.rfxtrx;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author edevaux
 *
 */
public class Config {
	private static final Logger LOGGER = Logger.getLogger( Config.class.getName() );
	
	private static Config config = null;
	
	private Properties prop;
	private String confFile;
	private long lastmodified;
	
	/**
	 * Default constructor of the singleton object instance
	 */
	private Config() {
		prop=null;
		lastmodified=-100000;
	}
	
	public Config(String configfile) throws FileNotFoundException, IOException {
		this();
		init(configfile);
	}

	/**
	 * Initialise the configuration with a property files in the file system
	 * provide also the context name (Tomcat WAR context name)
	 * The context help to discriminate the logs of configuration between WAR context
	 * @param configfile path to the property file
	 * @param context is the name of the war context , but can be something else(no check)
	 * @throws FileNotFoundException if the config file does not exist
	 * @throws IOException if other issue occurs on the property file
	 */
	synchronized public void init(String configfile) throws FileNotFoundException, IOException {
		confFile= configfile;
		lastmodified=-100000;
		doReload();
	}
	
	
	/**
	 * Does the loaded configuration is out dated compare to its property file
	 * @return true to say that a reload is necessary
	 */
	private boolean needReload() {
		File cfg= new File(confFile);
		return (cfg.lastModified() > lastmodified );
	}
	
	/**
	 * Does currect in memory configuration reflect the configuration file
	 * NB : the reload is automatic when necessary , this is to help the code to re-get
	 * configuration if needed.
	 * @return true is current config is up to date, false otherwise
	 */
	public boolean isUpToDate() {
		return !needReload();
	}
	
	/**
	 * If necessary do reload the configuration by the initially provided property file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void doReload() throws FileNotFoundException, IOException {
		if (needReload()) {
			File cfg= new File(confFile);
			lastmodified=cfg.lastModified();
			prop=new Properties(System.getProperties());
			prop.load(new FileInputStream(confFile));
			for (Object akey: prop.keySet()) {
				LOGGER.fine(String.valueOf(akey)+"="+String.valueOf(prop.get(akey)));
			}
		}
	}

	/**
	 * Get a boolean configuration value
	 * In the configuration file boolean values are: 'true' and 'false' (without quote and case insensible)
	 * If the param key is  unknown then return a default value (bdefault)
	 * If the the param key exist but is not 'true' or 'false' then it return false
	 * @param param key in the configuration file
	 * @param bdefault   default value
	 * @return the configuration file value or bdefault otherwise (unknown key), return false if key existing but the value has an incorrect syntax.
	 */
	public boolean get(String param, boolean bdefault) {
		boolean result = bdefault;
		String strResult = get(param, String.valueOf(bdefault));
		result = Boolean.parseBoolean(strResult);
		return result;
	}
	
	/**
	 * get a configuration value of the configuration file
	 * @param param
	 * @return the string of the configuration value , or null if the key does not exist
	 */
	synchronized public String get(String param) {
		return this.get(param, null);
	}

	/**
	 * get a configuration value of the configuration file
	 * If the provided key (param) is unknown then provide the default value
	 * @param param is the configuration key
	 * @param strdefault is the default value if the key does not exist
	 * @return the found value , or the default value (if parm (key) is not found)
	 */
	synchronized public String get(String param,String strdefault) {
		
	
		if (prop == null) throw new IllegalStateException("Configuration not initialized");
		try {
			doReload();
		} catch (IOException e) {
			// do not care !! (Not really then keep a trace)
			LOGGER.log(Level.WARNING,"Exception on configuration reload",e);
		}
		// get from cache
		String cached=prop.getProperty("$"+param);
		if (cached != null) return cached;

		String propValue;
		propValue = prop.getProperty(param);
		if (propValue==null) {
			propValue = System.getenv(param);
		}
		if (propValue == null) {
			if (strdefault == null) {
				LOGGER.severe( "' Key parameter '" + param + "' is not defined in configuration file '" + confFile + "'");
				return null;
			} else {
				LOGGER.warning( "'Key parameter '" + param + "' is not defined (use default value '" + strdefault + "') in configuration file '" + confFile + "'");
				propValue = strdefault;
				// put in cache
				prop.setProperty("$"+param, propValue);
			}
		}
		
		Pattern p = Pattern.compile("^.*(\\{\\{([^\\{\\}]+)\\}\\}).*$");
		Matcher m;
		boolean again;
		int nbLoop =1;
		do {
			again=false;
			m = p.matcher(propValue);
			if (m.matches()) {
				String akey = m.group(2);
				String subPropValue;
				if (akey.charAt(0) == '%') {
					subPropValue = System.getenv(akey.substring(1));
				} else {
					subPropValue = prop.getProperty(akey);
				}
				if (subPropValue != null) {
					propValue = propValue.substring(0,m.start(1))+ subPropValue + propValue.substring(m.end(1));
					if (nbLoop<10) again=true;
					nbLoop++;
				} else {
					propValue = propValue.substring(0,m.start(1))+ "[[" + akey + "]]" + propValue.substring(m.end(1));
					again=true;
				}
			}
		} while (again);
		propValue=propValue.replace("[[", "{{").replace("]]", "}}");
		// put in cache
		prop.setProperty("$"+param, propValue);
		return propValue;

	}

	/**
	 * Does the singleton instance is initialised
	 * @return true if the singleton object is initialised, false otherwise
	 */
	synchronized public boolean isInitialized() {
		return prop!=null;
	}
	
	/**
	 * Get the singleton instance object of the configuration
	 * @return
	 */
	synchronized public static Config getInstance() {
		if (config == null) config = new Config();
		return config;
	}
	
	/**
	 * Give the list of the keys defined in the configuration
	 * @return List<String> containing the keys
	 */
	synchronized public List<String> getKeyList() {
		if (! isInitialized()) return null;
		List<String> result = new ArrayList<String>();
		for (Object key:prop.keySet()) {
			result.add(String.valueOf(key));
		}
		return result;
	}
}