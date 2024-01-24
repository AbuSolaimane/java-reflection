package fields;

import java.lang.reflect.Field;
import java.util.List;
import java.util.StringJoiner;

public class CustomSerializer {

	public static String serialize(Object instance, int indentSize) throws IllegalArgumentException, IllegalAccessException {
		
		String indent = getIndentation(indentSize);
		StringJoiner serialization = new StringJoiner(",\n", "{\n", "\n" + getIndentation(indentSize - 1) + "}");
		Class<?> clazz = instance.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			
			field.setAccessible(true);
			String fieldName = formatString(field.getName());
			String value = null;
			if (field.getType().isPrimitive())
				value = formatPrimitive(field.get(instance), field.getType());
			else if (field.getType().isArray())
				value = "";
			else if (field.getType().equals(String.class))
				value = formatString(field.get(instance).toString());
			else
				value = serialize(field.get(instance), indentSize + 1);
			serialization.add(indent + fieldName +  " : " + value);
		}
		
		return serialization.toString();
	}
	
	private static String getIndentation(int indentSize) {
		
		return "\t".repeat(indentSize);
	}

	public static String formatString(String string) {
		
		return "\"" + string + "\"";
	}
	
	public static String formatPrimitive(Object value, Class<?> clazz) {
		if (List.of(boolean.class, int.class, long.class, short.class, float.class)
			.contains(clazz)) {
	            return value.toString();
	        } else if (value.getClass().equals(double.class) || value.getClass().equals(float.class)) {
	            return String.format("%.02f", value);
	        }

	        throw new RuntimeException(String.format("Type : %s is unsupported", clazz.getName()));
	}
}
