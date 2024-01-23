package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		PopupTypeInfo popupTypeInfo = new PopupTypeInfo(Object.class);
		System.out.println(popupTypeInfo);
		
		PopupTypeInfo popupTypeInfo2 = new PopupTypeInfo(int.class);
		System.out.println(popupTypeInfo2);
		
		PopupTypeInfo popupTypeInfo3 = new PopupTypeInfo(String[].class);
		System.out.println(popupTypeInfo3);
		
		List<String> strings = new ArrayList<>();
		PopupTypeInfo popupTypeInfo4 = new PopupTypeInfo(strings.getClass());
		System.out.println(popupTypeInfo4);
		
		System.out.println("----------------------------------------------");
		
		
		Set<Class<?>> implementedInterfaces = findAllImplementedInterfaces(ArrayList.class);
		System.out.println(implementedInterfaces);
	}
	
	public static Set<Class<?>> findAllImplementedInterfaces(Class<?> clazz) {
		
		if (clazz.getInterfaces() == null || clazz.getInterfaces().length == 0) {
			return null;
		}
		
		Set<Class<?>> implementedInterfaces = new HashSet<>();
		
		for (Class<?> implementedInterface : clazz.getInterfaces()) {
			
			implementedInterfaces.add(implementedInterface);
			Set<Class<?>> findAllImplementedInterfaces = findAllImplementedInterfaces(implementedInterface);
			if(findAllImplementedInterfaces != null)
				implementedInterfaces.addAll(findAllImplementedInterfaces);
			
		}
		return implementedInterfaces;
	}
	
}

class MainMethodOverloading {
	public static void main(String[] args) {
		System.out.println("Main method");
// Code
	}

	public static void main(String arg1, String arg2) {
		System.out.println("Overloaded main method");
// Code
	}
}