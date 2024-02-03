package fields;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

public class CustomParser {

	public static <T> T createObjectFromFile(Class<T> clazz, Path fielPath) throws IOException, NoSuchMethodException,
			InstantiationException, InvocationTargetException, IllegalAccessException {

		Constructor<T> constructor = clazz.getDeclaredConstructor();
		T object = constructor.newInstance();

		try (Scanner scanner = new Scanner(fielPath)) {

			while (scanner.hasNextLine()) {
				String[] fieldNameValuePair = scanner.nextLine().split("=");
				if (fieldNameValuePair.length != 2)
					continue;

				String fieldName = fieldNameValuePair[0];
				String fieldValue = fieldNameValuePair[1];

				Field field;
				try {
					field = clazz.getDeclaredField(fieldName);
				} catch (NoSuchFieldException | SecurityException e) {
					System.out.println(String.format("Property name : %s is unsupported", fieldName));
					continue;
				}
				field.setAccessible(true);
				Object parsedValue = parseValue(field.getType(), fieldValue);
				field.set(object, parsedValue);
			}
		}

		return object;
	}

	private static Object parseValue(Class<?> type, String fieldValue) {
		if (type.equals(int.class)) {
			return Integer.parseInt(fieldValue);
		} else if (type.equals(short.class)) {
			return Short.parseShort(fieldValue);
		} else if (type.equals(long.class)) {
			return Long.parseLong(fieldValue);
		} else if (type.equals(double.class)) {
			return Double.parseDouble(fieldValue);
		} else if (type.equals(float.class)) {
			return Float.parseFloat(fieldValue);
		} else if (type.equals(String.class)) {
			return fieldValue;
		}
		else if (type.isArray())
			return parseArray(type.componentType(), fieldValue);
		throw new RuntimeException(String.format("Type : %s unsupported", type.getTypeName()));
	}
	
	public static Object parseArray(Class<?> arrayType, String value) {
		
		String[] arrayValues = value.split(",");
		Object array = Array.newInstance(arrayType, arrayValues.length);
		int i = 0;
		for (String arrayValue : arrayValues) {
			
			Object parsedValue = parseValue(arrayType, arrayValue);
			Array.set(array, i++, parsedValue);
		}
		
		return array;
	}
}
