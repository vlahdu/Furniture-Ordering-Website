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
        List<Designer> designers=query.getResultList();
        System.out.println(designers);
        closeTransactionSession();
        return designers;
    }

    @Override
    public Designer getById(long id) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        String sql ="select designer from Designer designer";
        Query query=session.createQuery(sql,Designer.class);
        List<Designer> designers=query.getResultList();
        closeTransactionSession();
        return (Designer)designers.stream().filter((x) -> x.getId() == id).toArray()[0];
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