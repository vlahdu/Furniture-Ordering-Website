package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.DesignerDAO;
import com.ex.module.entities.actors.Designer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public class DesignerService extends SessionUtil implements DesignerDAO {
    @Override
    public void addDesigner(Designer designer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.save(designer);
        closeTransactionSession();
    }

    @Override
    public List<Designer> getAll() throws SQLException {
        openTransactionSession();
        String sql ="select designer from Designer designer";
        Query query=getSession().createQuery(sql,Designer.class);
        List<Designer> designerList=query.getResultList();
        designerList.forEach((x)-> System.out.println(x));
        System.out.println("*******************initialization of fields***************");
        designerList.forEach((x)-> System.out.println(x.getCompanyCollaboration()));
        designerList.forEach((x)-> System.out.println(x.getOwnProjects()));
        designerList.forEach((x)-> System.out.println(x.getCustomerSet()));
        designerList.forEach((x)-> System.out.println(x.getWantToCollaborate()));
        System.out.println("**********************************");
        //designers.forEach((x)-> Hibernate.initialize(x.getCompanyCollaboration()));
        closeTransactionSession();
        return designerList;
    }

    @Override
    public Designer getById(long id) throws SQLException {
        List<Designer> designerList =getAll();
        return (Designer)designerList.stream().filter((x) -> x.getId() == id).toArray()[0];
    }

    @Override
    public void update(Designer designer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(designer);
        closeTransactionSession();
    }

    @Override
    public void remove(Designer designer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(designer);
        closeTransactionSession();
    }
}