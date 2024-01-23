package constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String [] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
    	
    	printConstructorsData(Person.class);
    	printConstructorsData(Address.class);
 
        Address address = createInstanceWithArguments(Address.class, "First Street", 10);

        Person person = createInstanceWithArguments(Person.class,  address, "John", 20);
        System.out.println(person);
    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object ... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if(constructor.getParameterTypes().length == args.length) {

                return (T) constructor.newInstance(args);
            }
        }
        System.out.println("An appropriate constructor was not found");
        return null;
    }

    public static void printConstructorsData(Class<?> clazz) {
        Constructor<?> [] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));

        for (int i = 0 ; i < constructors.length ; i++) {
            Class<?> [] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map( type -> type.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }
    }
    
    public static <T> T createInstanceWithArguments2(Class<T> clazz, Object ... args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

    	Class<?>[] types = Arrays.stream(args).map(arg -> arg.getClass())
    				.toArray(Class<?>[]::new);
    	Constructor<T> constructor = clazz.getConstructor(types);
    	T newInstance = constructor.newInstance(args);
        return newInstance;
    }
}
