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
       // SpringApplication.run(SecuringWebApplication.class, args);
        SessionUtil sessionUtil = new SessionUtil();
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
//        Designer designer =new Designer("Designer","password");
//        session.save(designer);
        String sql ="select designer from Designer designer";
        Query query=session.createQuery(sql,Designer.class);
        List<Designer> designers=query.getResultList();

        //designers.forEach((x) -> System.out.println(x));
        Designer designer =designers.get(0);
        Set<Project> project = designer.getOwnProjects();
        project.forEach((x)-> System.out.println("<<"+x+">>"));


//        System.out.println("******************************");
//        System.out.println(project);
//        System.out.println("******************************");
//        Sofa sofa = new Sofa("sofa","mega commode");
//        TableAndChairs tableAndChairs =new TableAndChairs("table","Super util");
//        designer.addProject(sofa);
//        designer.addProject(tableAndChairs);

//        Designer designer=designers.get(0);
//        Project project=new Armchairs("armchair","super commode");
//        designer.addProject(project);
//        session.update(designer);
//        session.save(sofa);
//        session.save(tableAndChairs);
        sessionUtil.closeTransactionSession();
    }

}