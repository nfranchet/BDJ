package com.aeonconsulting.bdj.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {	
	private static Properties properties;
	
	private static void init() {
		InputStream reader = PropertyManager.class.getResourceAsStream("/"+PropertyManager.class.getPackage().getName().replace(".util", "").replace(".", "/")+"/bdfiler.properties");
		try {
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean getBooleanValue(BDFilerProperties param) {
		if (properties == null) {
			init();
		}
		if (properties.containsKey(param.getParam())) {
			return ToBoolean(properties.getProperty(param.getParam()));
		} else {
			return false;
		}
	}
	
	private static boolean ToBoolean(String value) {
		if (value == null || "".equals(value)) {
			return false;
		}
		String valueLower = value.toLowerCase();
		if ("t".equals(valueLower) || "true".equals(valueLower) || "1".equals(valueLower)) {
			return true;
		}
		return false;
	}

}
