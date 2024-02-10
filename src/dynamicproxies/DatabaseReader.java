package dynamicproxies;

import java.io.IOException;
import java.time.LocalDateTime;

public interface DatabaseReader {
    
    void connectToDatabase();
    
    @Cacheable
    String readCustomerIdByName(String firstName, String lastName) throws IOException;
    
    int countRowsInCustomersTable();
    
    void addCustomer(String id, String firstName, String lastName) throws IOException;

    @Cacheable
    LocalDateTime readCustomerBirthday(String id);
}