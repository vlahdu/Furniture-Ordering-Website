package com.ex.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.dao.DesignerDAO;
import com.ex.entities.actors.Designer;
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
        String sql="SELECT * FROM designer";
        Session session=getSession();
        Query query =session.createNativeQuery(sql).addEntity(Designer.class);
        List<Designer> designerList=query.list();
        closeTransactionSession();
        return designerList;
    }

    @Override
    public Designer getById(long id) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        String sql="SELECT * FROM designer WHERE ID = " + id ;
        Query query=session.createNativeQuery(sql).addEntity(Designer.class);
        Designer designer=(Designer)query.getSingleResult();
        closeTransactionSession();
        return designer;
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