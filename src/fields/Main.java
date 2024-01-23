package fields;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		System.out.println(CustomSerializer.serializer(new Product("hello", 2024)));
	}

}
