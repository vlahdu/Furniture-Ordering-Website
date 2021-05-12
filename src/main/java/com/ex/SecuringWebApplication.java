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
        ProjectService projectService = new ProjectService();
        DesignerService designerService = new DesignerService();
        CustomerService customerService = new CustomerService();
        CompanyService companyService = new CompanyService();

        //projects
        Armchairs armchairs = new Armchairs("armchair","commode armchair");
        Sofa sofa = new Sofa("sofa","commode sofa");
        TableAndChairs tableAndChairs = new TableAndChairs("chair","commode chair");
        //designer
        Designer designer = new Designer("designer","passwordD");
        //Customer
        Customer customer = new Customer("customer","passwordC");
        //Company
        Company company = new Company("company","passwordCo");

        //Designer actions
        designer.sendWantToCollaboration(company);
        designer.addProject(armchairs);
        designer.addProject(sofa);
        designer.addProject(tableAndChairs);
        designer.addCustomer(customer);
        //Customer
        customer.addLikedProject(armchairs);
        customer.addLikedProject(sofa);
        customer.addLikedProject(tableAndChairs);
        //Company
        company.acceptAllRequest();
        company.sendWantToCollaboration(designer);
        designer.acceptAllRequest();

        projectService.addProject(armchairs);
        projectService.addProject(sofa);
        projectService.addProject(tableAndChairs);
        designerService.addDesigner(designer);
        companyService.addCompany(company);
        customerService.addCustomer(customer);

    }

}