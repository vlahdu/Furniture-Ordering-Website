package com.ex;

import com.ex.entities.actors.Company;
import com.ex.entities.actors.Customer;
import com.ex.entities.actors.Designer;
import com.ex.entities.project.Armchairs;
import com.ex.entities.project.Project;
import com.ex.entityservices.CompanyService;
import com.ex.entityservices.CustomerService;
import com.ex.entityservices.DesignerService;
import com.ex.entityservices.ProjectService;

import java.sql.SQLException;

/*
 * @IonToncu
 *
 * */

/*
 * @vlahdu
 *
 * */

public class Main {
    public static void main(String[] args) throws SQLException {

        DesignerService designerService = new DesignerService();
        Designer designer = new Designer();
        designerService.addDesigner(designer);
    }
}

