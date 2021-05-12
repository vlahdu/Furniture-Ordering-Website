package Test;

import com.ex.module.entities.actors.Company;
import com.ex.module.entityservices.CompanyService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @org.junit.jupiter.api.Test
    void addCompany() throws SQLException {
        CompanyService companyService = new CompanyService();
        Company company=new Company();
        try {
            companyService.addCompany(company);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            companyService.remove(company);
            assertTrue(true,"the test not throw an exception");
        }
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        CompanyService companyService = new CompanyService();
        List<Company> companyList = companyService.getAll();

        for (Company company : companyList)
        {
            assertNotNull(company, "should not be null");
        }
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned set")
    void getById() throws SQLException {
        CompanyService companyService = new CompanyService();
        assertNotNull(companyService.getById(2),"check company not null");
    }

    @org.junit.jupiter.api.Test
    void update() {

        try{
            CompanyService companyService = new CompanyService();
            Company company=companyService.getById(2);
            companyService.update(company);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }

    }

    @org.junit.jupiter.api.Test
    void remove() throws SQLException {
        CompanyService companyService = new CompanyService();
        Company company=new Company();
        try {
            companyService.addCompany(company);
            companyService.remove(company);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }
    }
}