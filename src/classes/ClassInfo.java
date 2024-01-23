package classes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassInfo {

	public static void printClassesInfos(Class<?>... classes) {
		
		for (Class<?> classClass : classes) {
			
			System.out.println("Class name : " + classClass.getName());
			System.out.println("canonical name : " + classClass.getCanonicalName());
			System.out.println("Class modifiers : " + classClass.getModifiers());
			System.out.println("Class simple name : " + classClass.getSimpleName());
			System.out.println("Class package name : " + classClass.getPackageName());
			System.out.println("Class type name : " + classClass.getTypeName());
			
			System.out.println("Class is array : " + classClass.isArray());
			System.out.println("Class is AnonymousClass : " + classClass.isAnonymousClass());
			System.out.println("Class is enum : " + classClass.isEnum());
			System.out.println("Class is interface : " + classClass.isInterface());
			System.out.println("Class is primitive : " + classClass.isPrimitive());
			
			for (Class<?> clazz : classClass.getInterfaces()) {
				
				System.out.println("Class simple name : " + clazz.getSimpleName());
				System.out.println("Class package name : " + clazz.getPackageName());
			}
			
			System.out.println("-----------------------------------------------------");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<String> string = String.class;
		
		Map<String, Integer> map = new HashMap<>();
		Class<?> mapClass = map.getClass();
		
		Class<?> squareClass = Class.forName("exercices.ClassInfo$Square");
		
		printClassesInfos(string, mapClass, squareClass);
		
		Drawable drawable = new Drawable() {
			
			@Override
			public int getNumberOfCorners() {
				
				return 5;
			}
		};
		printClassesInfos(int.class, Collection.class, int[].class, int[][].class, Color.class, drawable.getClass());
	}
	
	private enum Color {
        BLUE,
        RED,
        GREEN
    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    static class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }
}
