package Test.services;

import com.ex.module.entities.actors.Designer;
import com.ex.module.entityservices.DesignerService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DesignerServiceTest {

    @org.junit.jupiter.api.Test
    void addDesigner() throws SQLException {
        DesignerService designerService = new DesignerService();
        Designer designer=new Designer("testDesigner","testPassword");
        try {
            designerService.addDesigner(designer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            designerService.remove(designer);
            assertTrue(true,"the test not throw an exception");
        }
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
        assertNotNull(designerService.getById(1),"check designer not null");
    }

    @org.junit.jupiter.api.Test
    void update() {

        try{
            DesignerService designerService = new DesignerService();
            Designer designer=designerService.getById(1);
            designerService.update(designer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }

    }

    @org.junit.jupiter.api.Test
    void remove() throws SQLException {
        DesignerService designerService = new DesignerService();
        Designer designer=new Designer("testDesigner","testPassword");
        try {
            designerService.addDesigner(designer);
            designerService.remove(designer);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }
    }
}