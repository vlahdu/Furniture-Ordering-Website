package Test;

import com.ex.module.entities.project.Project;
import com.ex.module.entityservices.ProjectService;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @org.junit.jupiter.api.Test
    void addProject() throws SQLException {
        ProjectService projectService = new ProjectService();
        Project project=new Project();
        try {
            projectService.addProject(project);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            projectService.remove(project);
            assertTrue(true,"the test not throw an exception");
        }
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        ProjectService projectService = new ProjectService();
        List<Project> projectList = projectService.getAll();

        for (Project project : projectList)
        {
            assertNotNull(project, "should not be null");
        }
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Ensure correct handling of returned set")
    void getById() throws SQLException {
        ProjectService projectService = new ProjectService();
        Project project = projectService.getById(33);
        assertNotNull(project,"check project not null");
    }

    @org.junit.jupiter.api.Test
    void update() {

        try{
            ProjectService projectService = new ProjectService();
            Project project=projectService.getById(33);
            projectService.update(project);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }

    }

    @org.junit.jupiter.api.Test
    void remove() throws SQLException {
        ProjectService projectService = new ProjectService();
        Project project=new Project();
        try {
            projectService.addProject(project);
            projectService.remove(project);
        }catch (SQLException e){
            assertFalse(true,"the test throw an exception");
        }finally {
            assertTrue(true,"the test not throw an exception");
        }
    }
}