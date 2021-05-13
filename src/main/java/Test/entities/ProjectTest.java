package Test.entities;

import com.ex.module.entities.actors.Designer;
import com.ex.module.entities.project.Project;
import com.ex.module.entityservices.DesignerService;
import com.ex.module.entityservices.ProjectService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void setDesigner() throws SQLException {

        ProjectService projectService = new ProjectService();
        DesignerService designerService = new DesignerService();
        List<Project> projectList =null;
        try {
            projectList = projectService.getAll();
            Designer designer = designerService.getById(1);
            projectList.forEach((x) ->x.setDesigner(designer));
            System.out.println("******************************************");
            projectList.forEach((x) -> System.out.println(x.getDesigner()));
            System.out.println("******************************************");
            //projectList.forEach((x) ->{assertEquals(designer,x.getDesigner(),"not same designer");});

        }catch (SQLException e){
            assertNotNull(projectList,"throw an exception");
        }

    }
}