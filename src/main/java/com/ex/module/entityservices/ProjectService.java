package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.ProjectDAO;
import com.ex.module.entities.project.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void addProject(Project project) throws SQLException {

        openTransactionSession();
        Session session=getSession();
        session.save(project);
        closeTransactionSession();

    }

    @Override
    public List<Project> getAll() throws SQLException {
        openTransactionSession();
        String sql="SELECT * FROM project";
        Session session=getSession();
        Query query =session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> designerList=query.list();
        closeTransactionSession();
        return designerList;
    }

    @Override
    public Project getById(long id) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        String sql="SELECT * FROM project WHERE ID = " + id ;
        Query query=session.createNativeQuery(sql).addEntity(Project.class);
        Project project=(Project)query.getSingleResult();
        closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(project);
        closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(project);
        closeTransactionSession();
    }
}