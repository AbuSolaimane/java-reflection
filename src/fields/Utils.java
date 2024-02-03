package fields;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static <T> T concat(Class<?> clazz, Object... values) {
		
		List<Object> objects = new ArrayList<>();
		for (Object object : values) {
			
			if(object.getClass().isArray()) {
				int length = Array.getLength(object);
				for (int i = 0; i < length; i++) {
					objects.add(Array.get(object, i));
				}
			}
				
			else
				objects.add(object);
		}
		Object concatenatedList = Array.newInstance(clazz, objects.size());
		for (int i = 0; i < objects.size(); i++) {
			
			Array.set(concatenatedList, i, objects.get(i));
		}
		
		
		return (T) concatenatedList;
	}
}
