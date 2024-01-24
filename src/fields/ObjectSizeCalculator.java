package fields;

import java.lang.reflect.Field;

public class ObjectSizeCalculator {
	
	private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;
    
     public static long sizeOfObject(Object object) throws IllegalAccessException {
    	 
    	 long objectSize = HEADER_SIZE + REFERENCE_SIZE;
    	 for (Field field : object.getClass().getDeclaredFields()) {
    		 
    		 field.setAccessible(true);
    		 if (int.class.equals(field.getType()))
    			 objectSize += 4;
    		 else if (short.class.equals(field.getType()))
    			 objectSize += 2;
    		 else if (long.class.equals(field.getType()))
    			 objectSize += 8;
    		 else if (byte.class.equals(field.getType()))
    			 objectSize += 1;
    		 else if (double.class.equals(field.getType()))
    			 objectSize += 8;
    		 else if (float.class.equals(field.getType()))
    			 objectSize += 4;
    		 else if (String.class.equals(field.getType()))
    			 objectSize += ((String) field.get(object)).getBytes().length + REFERENCE_SIZE + HEADER_SIZE;
    		 else
    			 objectSize += sizeOfObject(field.get(object));
    	 }
    	 
    	 return objectSize;
     }
}
