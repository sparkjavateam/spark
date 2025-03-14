package spark;

import java.lang.reflect.Field;

/**
 * Replacement for Powermock class "Whitebox"
 */
public class Whitebox {

	public static void setInternalState(Object object, String fieldname, Object value) {
		try {
			Field field = object.getClass().getDeclaredField(fieldname);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			throw new RuntimeException("Error setting " + object.getClass().getName() + " field " + fieldname + " value", e);
		}
	}

	public static Object getInternalState(Object object, String fieldname) {
		try {
			Field field = object.getClass().getDeclaredField(fieldname);
			field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			throw new RuntimeException("Error getting " + object.getClass().getName() + " field " + fieldname + " value", e);
		}
	}
}
