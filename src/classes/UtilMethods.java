package classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface UtilMethods {

	String[] JDK_PACKAGE_PREFIXES = {"com.sun.", "java", "javax",
				"jdk", "org.w3c", "org.xml"};
	
	public static boolean isJDKClass(Class<?> clazz) {
		
		return Arrays.stream(JDK_PACKAGE_PREFIXES)
				.anyMatch(pre -> clazz.getPackage() == null ||
						clazz.getPackageName().startsWith(pre));
	}

	public static List<String> getAllInheritedClassNames(Class<?> clazz) {
		
		if (clazz.isInterface()) {
			
			return Arrays.stream(clazz.getInterfaces())
					.map(inter -> inter.getSimpleName())
					.collect(Collectors.toList());
		}
		return clazz.getSuperclass() != null ? 
					Arrays.asList(clazz.getSuperclass().getSimpleName()) : null;
	}
}
