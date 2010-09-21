package com.aeonconsulting.bdj.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Classe pour aider a la construction des DTO
 *
 */
public class DTOHelper {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Integer getInteger(String value) {
		return getInteger(value, null);
	}
	
	public static Integer getInteger(String value, Integer defaultValue) {
		return (!"".equals(value) && value != null) ? Integer
				.valueOf(value) : defaultValue;
	}
	
	public static Double getDouble(String value) {
		return getDouble(value, null);
	}
	
	public static Double getDouble(String value, Double defaultValue) {
		return (!"".equals(value) && value != null) ? Double
				.valueOf(value) : defaultValue;
	}
	
	public static Boolean getBoolean(String value) {
		return Integer.valueOf(value) == 0 ? false : true;
	}
	
	
	public static String toJson(Object obj) {
		StringBuffer jsonBuffer = new StringBuffer("{");
		
		for (Field champ : obj.getClass().getDeclaredFields()) {
			String champName = champ.getName().substring(0,1).toUpperCase()+champ.getName().substring(1);
			if (!champName.contains("$")) {
				jsonBuffer.append("'").append(champ.getName()).append("': '");
				try {
					Method method = obj.getClass().getMethod("get"+champName, new Class[]{});
					Object value = method.invoke(obj, new Object[]{});
					if (value instanceof String) {
						String valueStr = new String(Charset.forName("UTF8")
								.encode(((String) value).trim()).array()).trim();
						jsonBuffer.append(valueStr.replaceAll("'", "\\\\'"));
					} else if (value instanceof Boolean) {
						String booleanStr = ((Boolean) value) ? "true" : "false";
						jsonBuffer.append(booleanStr.replaceAll("'", "\\\\'"));
					} else {
						jsonBuffer.append(value);
					}
				} catch (SecurityException e1) {
					jsonBuffer.append("#2#");
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					jsonBuffer.append("#3#");
					e1.printStackTrace();
				} catch (IllegalArgumentException e) {
					jsonBuffer.append("#4#");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					jsonBuffer.append("#5#");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					jsonBuffer.append("#6#");
					e.printStackTrace();
				}
				jsonBuffer.append("',");
			}
		}
		jsonBuffer.append("}");
		return jsonBuffer.toString();
	}

	public static Date getDate(String value) {
		Date date = null;
		if (!"".equals(value)) {
			try {
				date = sdf.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
				// La date reste null!!
			}
		}
		return date;
	}
}
