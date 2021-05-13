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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.parameters.P;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SecuringWebApplication {

    public static void main(String[] args) throws Throwable {
        DesignerService designerService = new DesignerService();
        CompanyService companyService = new CompanyService();
//        List<Designer> designers = designerService.getAll();
////        designers.forEach((x) -> System.out.println(x.getWantToCollaborate()) );
//        Designer designer=(Designer)designers.toArray()[0];
//        Company company =(Company) designer.getCompanyCollaboration().toArray()[0];
//        System.out.println(company);
////        designer.acceptAllRequest();

//        List<Company> companies =companyService.getAll();
//
//        Company company=(Company) companies.toArray()[0];
//        Designer designer =(Designer) company.getWantToCollaborate().toArray()[0];
//        System.out.println("wow->"+designer);
//        System.out.println(company.getDesignerSet());
//        company.acceptAllRequest();
//        designerService.update(designer);
//        companyService.update(company);
//
        SessionUtil sessionUtil = new SessionUtil();
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        String sql ="select company from Company company";
        Query query=session.createQuery(sql,Company.class);
        List<Company> companies=query.getResultList();
        System.out.println(companies);
        Company company=(Company) companies.toArray()[0];
        Designer designer =(Designer) company.getWantToCollaborate().toArray()[0];
        System.out.println("wow->"+designer);
        System.out.println(company.getDesignerSet());
        company.acceptAllRequest();

        session.update(company);
        session.update(designer);
        sessionUtil.closeTransactionSession();



    }

}