package com.ex;


import com.ex.bl.SessionUtil;
import com.ex.module.entities.actors.Company;
import com.ex.module.entities.actors.Customer;
import com.ex.module.entities.actors.Designer;
import com.ex.module.entities.project.Armchairs;
import com.ex.module.entities.project.Project;
import com.ex.module.entities.project.Sofa;
import com.ex.module.entities.project.TableAndChairs;
import com.ex.module.entityservices.CompanyService;
import com.ex.module.entityservices.CustomerService;
import com.ex.module.entityservices.DesignerService;
import com.ex.module.entityservices.ProjectService;
<<<<<<< HEAD
import org.hibernate.Hibernate;
=======
>>>>>>> IonToncu
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.parameters.P;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
//SpringApplication.run(SecuringWebApplication.class, args); todo don't forget this
@SpringBootApplication
public class SecuringWebApplication {

    public static void main(String[] args) throws Throwable {
<<<<<<< HEAD
        SpringApplication.run(SecuringWebApplication.class, args);
=======

        ProjectService projectService=new ProjectService();


>>>>>>> IonToncu
    }

}