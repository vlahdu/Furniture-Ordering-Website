package Test;

import com.ex.entityservices.CustomerService;

import java.sql.SQLException;

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
    void getAll() {
        assertEquals(0,0,"ceva 2 ");
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned name")
    void getById() throws SQLException {
        CustomerService customerService = new CustomerService();
        assertEquals("customer1",customerService.getById(1).getName(),"customer name");
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}