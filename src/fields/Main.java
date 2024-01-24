package fields;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Company company = new Company("Udemy", "San Francisco", new Address("Harrison Street", (short) 600));
		Address address = new Address("Main Street", (short) 1);
		Person person = new Person("John", true, 29, 100.555f, address, company);
		System.out.println(CustomSerializer.serialize(person, 1));
//		long sizeOfObject = ObjectSizeCalculator.sizeOfObject(person);
//		System.out.println(sizeOfObject);
		int[][] arr = {{1, 2, 3}, {1, 2}};
		String array = ArrayInspector.inspect(arr);
		System.out.println(array);
	}

}
