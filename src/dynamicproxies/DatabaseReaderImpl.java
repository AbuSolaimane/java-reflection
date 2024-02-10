package dynamicproxies;

import java.io.IOException;
import java.time.LocalDateTime;

public class DatabaseReaderImpl implements DatabaseReader {

	@Override
	public void connectToDatabase() {
		
		
	}

	@Override
	public String readCustomerIdByName(String firstName, String lastName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRowsInCustomersTable() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCustomer(String id, String firstName, String lastName) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public LocalDateTime readCustomerBirthday(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
