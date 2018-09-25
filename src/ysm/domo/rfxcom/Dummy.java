package ysm.domo.rfxcom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ysm.domo.rfxcom.rfxtrx.protocol.JSMessageBean;

public class Dummy {

	public static void main(String[] args) {
		ScriptEngineManager engineManager =	new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("javascript");
		try {
			// eval base script for message generation
			 JSMessageBean msgBean = new JSMessageBean();
			 engine.put("msg", msgBean);
			 engine.put(ScriptEngine.FILENAME, "InputMessage");
			 engine.eval("function x() {msg.setType(1).setSubtype(2).setData([3,4,5])}");
			 Object objResult =engine.eval("x()");
			 System.out.println("Message : " + msgBean.toString());
			 // objResult get the result
			 //System.out.println("obj:"+String.valueOf(objResult));
			// System.out.println("obj class:"+objResult.getClass().getName());
			
		} catch (ScriptException  e) {
				e.printStackTrace();
		}
	}

}
