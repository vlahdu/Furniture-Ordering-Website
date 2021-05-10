package Test;

import com.ex.module.entities.project.Armchairs;
import com.ex.module.entities.project.Project;
import com.ex.module.entityservices.ProjectService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @org.junit.jupiter.api.Test
    void addProject() {
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        ProjectService projectService = new ProjectService();
        List<Project> projectList = projectService.getAll();

        assertNotNull(projectList, "should not be null");

    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned name")
    void getById() throws SQLException {
        ProjectService projectService = new ProjectService();
        Armchairs armchairs = (Armchairs)projectService.getById(33);
        assertEquals("armchair",armchairs.getName(),"project name");
    }

    @org.junit.jupiter.api.Test
    void update() {
        assertEquals(0,0, "ceva");
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}