package com.ex;


import com.ex.entities.actors.Designer;
import com.ex.entityservices.DesignerService;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        DesignerService designerService = new DesignerService();
        Designer designer = new Designer();
        designerService.addDesigner(designer);
    }
}

