package Test;

import com.ex.entityservices.CompanyService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @org.junit.jupiter.api.Test
    void addCompany() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        assertEquals(0,0,"ceva");
    }

    @org.junit.jupiter.api.Test
    void getById() throws SQLException {
       CompanyService companyService = new CompanyService();
        assertEquals("aQuasgrel",companyService.getById(1).getCompanyName(),"company name");
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}