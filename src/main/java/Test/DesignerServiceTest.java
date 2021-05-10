package Test;

import com.ex.module.entities.actors.Designer;
import com.ex.module.entityservices.DesignerService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DesignerServiceTest {

    @org.junit.jupiter.api.Test
    void addDesigner() {
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        DesignerService designerService = new DesignerService();
        List<Designer> designerList = designerService.getAll();

        for (Designer designer : designerList)
        {
            assertNotNull(designer, "should not be null");
        }
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned set")
    void getById() throws SQLException {
        DesignerService designerService = new DesignerService();
        assertNotNull(designerService.getById(34),"check designer not null");
    }

    @org.junit.jupiter.api.Test
    void update() {
        assertEquals(0,0, "ceva");
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}