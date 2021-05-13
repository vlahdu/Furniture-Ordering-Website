package Test.services;

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
    void addCustomer() throws SQLException {
        CustomerService customerService = new CustomerService();
        Customer customer=new Customer();
        try {
            customerService.addCustomer(customer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            customerService.remove(customer);
            assertTrue(true,"the test not throw an exception");
        }
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.getAll();

        for (Customer customer : customerList)
        {
            assertNotNull(customer, "should not be null");
        }
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned set")
    void getById() throws SQLException {
        CustomerService customerService = new CustomerService();
        assertNotNull(customerService.getById(1),"check customer not null");
    }

    @org.junit.jupiter.api.Test
    void update() {

        try{
            CustomerService customerService = new CustomerService();
            Customer customer=customerService.getById(1);
            customerService.update(customer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }

    }

    @org.junit.jupiter.api.Test
    void remove() throws SQLException {
        CustomerService customerService = new CustomerService();
        Customer customer=new Customer();
        try {
            customerService.addCustomer(customer);
            customerService.remove(customer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }
    }
}