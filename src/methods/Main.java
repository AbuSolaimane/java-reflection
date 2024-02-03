package methods;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		//Utils.testGetters(Product.class);
		try {
			Utils.runTestClass(PaymentServiceTest.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
