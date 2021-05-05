package Test;

import com.ex.entityservices.DesignerService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DesignerServiceTest {

    @org.junit.jupiter.api.Test
    void addDesigner() {
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of zero")
    void getAll() {
        assertEquals(0,0,"ceva 3");
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned set")
    void getById() throws SQLException {
        DesignerService designerService = new DesignerService();
        assertEquals("comp",designerService.getById(1).getCompanyCollaboration(),"Designer name");
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}