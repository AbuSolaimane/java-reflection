package fields;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, IOException {
//		Company company = new Company("Udemy", "San Francisco", new Address("Harrison Street", (short) 600));
//		Address address = new Address("Main Street", (short) 1);
//		Person person = new Person("John", true, 29, 100.555f, address, company);
//		System.out.println(CustomSerializer.serialize(person, 1));
//		long sizeOfObject = ObjectSizeCalculator.sizeOfObject(person);
//		System.out.println(sizeOfObject);
//		int[][] arr = {{1, 2, 3}, {1, 2}};
//		String array = ArrayInspector.inspect(arr);
//		System.out.println(array);
		
//		final Path GAME_CONFIG_PATH = Path.of("resources/game-properties.cfg");
//	    final Path UI_CONFIG_PATH = Path.of("resources/user-interface.cfg");
		//GameConfig config = CustomParser.createObjectFromFile(GameConfig.class, GAME_CONFIG_PATH);
//		UserInterfaceConfig config = CustomParser.createObjectFromFile(UserInterfaceConfig.class, UI_CONFIG_PATH);
//
//        System.out.println(config);
		
		String[] concat = Utils.concat(String.class, new String[]{"a", "b"}, "c", new String[] {"d", "e"});
		String string = Arrays.toString(concat);
		System.out.println(string);
	}

}
