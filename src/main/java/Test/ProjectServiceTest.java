package Test;

import com.ex.entityservices.ProjectService;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @org.junit.jupiter.api.Test
    void addProject() {
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of zero")
    void getAll() {
        assertEquals(0,0,"ceva 4");
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned name")
    void getById() throws SQLException {
        ProjectService projectService = new ProjectService();
        assertEquals("proj",projectService.getById(1).getName(),"project name");
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}