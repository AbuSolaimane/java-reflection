package fields;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class CustomSerializer {

	public static <T> String serializer(T instance) throws IllegalArgumentException, IllegalAccessException {
		
		StringJoiner serialization = new StringJoiner(",\n", "{\n", "\n}");
		Class<T> clazz = (Class<T>) instance.getClass();
		
		for (Field field : clazz.getDeclaredFields()) {
			
			String fieldName = field.getName();
			Object value = field.get(instance);
			serialization.add(fieldName +  " : " + value);
		}
		
		return serialization.toString();
	}
}
