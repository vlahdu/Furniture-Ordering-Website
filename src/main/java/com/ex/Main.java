package com.ex;

import com.ex.bl.SessionUtil;

//import com.ex.config.SpringConfig;

import com.ex.entities.actors.Company;

import com.ex.entityservices.CompanyService;


import java.sql.SQLException;


/*
 * @IonToncu
 *
 * */
public class Main {
    public static void main(String[] args) throws SQLException {
        CompanyService companyService=new CompanyService();
        Company c=new Company();
                c.setCompanyName("avd");
        //companyService.addCompany(c);
        System.out.println(companyService.getById(1).getCompanyName());


    }
}

