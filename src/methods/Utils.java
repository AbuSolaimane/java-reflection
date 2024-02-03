package methods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static void testGetters(Class<?> clazz) {
		
		for(Field field : clazz.getDeclaredFields()) {
			
			Method method;
			try {
				method = clazz.getMethod("get" + capitalize(field.getName()));
			} catch (NoSuchMethodException e) {
				throw new IllegalStateException(String.format("the field %s doesn't have a getter method or has params", field.getName()));
			}
			
			if (!method.getReturnType().equals(field.getType()))
				throw new IllegalStateException(String.format("the getter Method %s has %s as return type but expected %s type", method.getName(), method.getReturnType().getSimpleName(), field.getType().getSimpleName()));
		}
	}
	
	private static String capitalize(String name) {
		
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static Map<String, Method> getMethodsMapOf(Class<?> clazz) {
		
		Map<String, Method> methods = new HashMap<>();
		for (Method method : clazz.getMethods()) {
			
			methods.put(method.getName(), method);
		}
		
		return methods;
	}
	
	public static void runTestClass(Class<?> testClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		Constructor<?> constructor = testClass.getConstructor();
		Object testObject = constructor.newInstance();
		try {
			Method method = testClass.getMethod("beforeClass");
			if (method.getReturnType().equals(void.class))
				method.invoke(testObject);
				
		} catch (NoSuchMethodException e) {
			
		}
		
		Method setupTestMethod;
		try {
			setupTestMethod = testClass.getMethod("setupTest");
		} catch (NoSuchMethodException e) {
			setupTestMethod = null;
		}
		
		for (Method testMethod : testClass.getMethods()) {
			
			if (!testMethod.getName().startsWith("test"))
				continue;
			if (testMethod.getParameterCount() != 0)
				continue;
			if (!testMethod.getReturnType().equals(void.class))
				continue;
			
			Object newTestObject = constructor.newInstance();
			if (setupTestMethod != null)
				setupTestMethod.invoke(newTestObject);
			testMethod.invoke(newTestObject);
		}
		
		try {
			Method method = testClass.getMethod("afterClass");
			if (method.getReturnType().equals(void.class))
				method.invoke(testObject);
				
		} catch (NoSuchMethodException e) {
			
		}
	}
}
