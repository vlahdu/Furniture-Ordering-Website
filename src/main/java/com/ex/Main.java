package com.ex;

import com.ex.entities.actors.Company;
import com.ex.entities.actors.Customer;
import com.ex.entities.project.Project;
import com.ex.entityservices.CompanyService;
import com.ex.entityservices.CustomerService;
import com.ex.entityservices.ProjectService;

import java.sql.SQLException;

/*
 * @IonToncu
 *
 * */
public class Main {
    public static void main(String[] args) throws SQLException {

        CompanyService companyService = new CompanyService();
        Company company = new Company();
        company.setName("comp");
        companyService.addCompany(company);

        ProjectService projectService = new ProjectService();
        Project project = new Project();
        project.setName("proj");
        projectService.addProject(project);

    }
}

