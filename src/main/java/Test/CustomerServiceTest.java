package Test;

import com.ex.module.entities.actors.Customer;
import com.ex.module.entityservices.CustomerService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @vlahdu
 *
 * */
class CustomerServiceTest {

    @org.junit.jupiter.api.Test
    void addCustomer() {
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of zero")
    void getAll() throws SQLException {
        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getAll();

        for (Customer customer : customerList)
        {
            assertNotNull(customer, "should not be null");
        }
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned name")
    void getById() throws SQLException {
        CustomerService customerService = new CustomerService();
        assertEquals("customer1",customerService.getById(1).getName(),"customer name");
    }

    @org.junit.jupiter.api.Test
    void update() {
        assertEquals(0,0, "ceva");
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}