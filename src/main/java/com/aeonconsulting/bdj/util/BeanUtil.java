package com.aeonconsulting.bdj.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aeonconsulting.bdj.services.BDJException;

/**
 * Helper pour la serialisation/deserialisation des Beans 
 * pour la sauvegarde en BD
 *
 */
public class BeanUtil {

	private static Map<String, Field[]> _fields = new HashMap<String, Field[]>();
	private static Map<String, Map<String,Method>> _fieldsGet = new HashMap<String, Map<String,Method>>();
//	private static Map<String, Map<String,Method>> _fieldsSet = new HashMap<String, Map<String,Method>>();
	private static Map<String, String> _fieldsAsString = new HashMap<String, String>();
	
	/**
	 * Recupère la liste des champs d'un objet
	 * 
	 * @param obj
	 * @return
	 */
	public static String getFieldsAsString(Object obj) {
		if (!_fieldsAsString.containsKey(obj.getClass().getCanonicalName())) {
			Field[] fields = obj.getClass().getFields();
			_fields.put(obj.getClass().getCanonicalName(), fields);
			boolean sep = false;
			StringBuffer buffer = new StringBuffer();
			for (Field field : fields) {
				if (sep) {
					buffer.append(",");
				} else {
					sep = true;
				}
				buffer.append(field.getName());
			}
			_fieldsAsString.put(obj.getClass().getCanonicalName(), buffer.toString());
		}
		return _fieldsAsString.get(obj.getClass().getCanonicalName());
	}

	public static Map<String, Object> getValues(Object obj) throws BDJException {
		if (!_fieldsAsString.containsKey(obj.getClass().getCanonicalName())) {
			getFieldsAsString(obj);
		}
		if (!_fieldsGet.containsKey(obj.getClass().getCanonicalName())) {
			Map<String, Method> getter = new HashMap<String, Method>();
			for (Field field : _fields.get(obj.getClass().getCanonicalName())) {
				// On trouve la methode getter
				Method method = null;
				String nameField = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
				try {
					method = obj.getClass().getMethod("get"+nameField, new Class[]{});
				} catch (SecurityException e) {
					// On ne peut rien contre ca
					throw new BDJException("Impossible d'acceder au champ "+field.getName());
				} catch (NoSuchMethodException e) {
					// On essaie avec le is
					try {
						method = obj.getClass().getMethod("is"+nameField, new Class[]{});
					} catch (SecurityException e1) {
						throw new BDJException("Impossible d'acceder au champ "+field.getName());
					} catch (NoSuchMethodException e1) {
						throw new BDJException("Impossible d'acceder au champ "+field.getName());
					}
				}
				getter.put(field.getName(), method);
			}
			_fieldsGet.put(obj.getClass().getCanonicalName(), getter);
		}
		Map<String, Object> values = new HashMap<String, Object>();
		for (Field field : _fields.get(obj.getClass().getCanonicalName())) {
			try {
				values.put(field.getName(), _fieldsGet.get(obj.getClass().getCanonicalName()).get(field.getName()).invoke(obj, new Object[]{}));
			} catch (IllegalArgumentException e) {
				throw new BDJException("Impossible d'acceder a la valeur du champ "+field.getName());
			} catch (IllegalAccessException e) {
				throw new BDJException("Impossible d'acceder a la valeur du champ "+field.getName());
			} catch (InvocationTargetException e) {
				throw new BDJException("Impossible d'acceder a la valeur du champ "+field.getName());
			}
		}
		return values;
	}
	
	public static String getValuesAsString(Object obj) throws BDJException {
		Map<String, Object> values = getValues(obj);
		StringBuffer sortie = new StringBuffer();
		boolean sep = false;
		for (Object value : values.entrySet()) {
			if (value == null) {
				sortie.append("");
			} else if (value instanceof Boolean) {
				if (((Boolean)value)) {
					sortie.append("1");
				} else {
					sortie.append("0");
				}
			} else if (value instanceof Date) {
				// TODO : to be done
				sortie.append("");
			} else if (value instanceof Number) {
				sortie.append(value);
			} else {
				// TODO : Attention a l'encoding et aux caractères "a la con"
				sortie.append("'").append(value).append("'");
			}
			if (sep) {
				sortie.append(",");
			} else {
				sep = true;
			}
		}
		return sortie.toString();
	}
}
