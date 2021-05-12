package com.ex;


import com.ex.bl.SessionUtil;
import com.ex.module.entities.actors.Designer;
import com.ex.module.entities.project.Armchairs;
import com.ex.module.entities.project.Project;
import com.ex.module.entities.project.Sofa;
import com.ex.module.entities.project.TableAndChairs;
import com.ex.module.entityservices.DesignerService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecuringWebApplication {

    public static void main(String[] args) throws Throwable {
            DesignerService designerService = new DesignerService();

        System.out.println(designerService.getById(1));
    }

}