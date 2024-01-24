package fields;

import java.lang.reflect.Array;
import java.util.StringJoiner;

public class ArrayInspector {

	public static String inspect(Object object) {
		
		StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
		if(object.getClass().isArray()) {
			
			int length = Array.getLength(object);
			for (int i = 0; i < length; i++) {
				
				Object element = Array.get(object, i);
				System.out.println(object.getClass().componentType());
				if(element.getClass().isArray())
					stringJoiner.add(inspect(element));
				else
					stringJoiner.add(element.toString());
			}
		}
		
		return stringJoiner.toString();
	}
}
