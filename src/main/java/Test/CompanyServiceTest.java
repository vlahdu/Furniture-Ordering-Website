package Test;

import com.ex.entities.actors.Company;
import com.ex.entities.project.Project;
import com.ex.entityservices.CompanyService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @org.junit.jupiter.api.Test
    void addCompany() {
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
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned name")
    void getById() throws SQLException {
       CompanyService companyService = new CompanyService();
        assertEquals("comp",companyService.getById(1).getName(),"company name");
    }

    @org.junit.jupiter.api.Test
    void update() {
        assertEquals(0,0, "ceva");
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}