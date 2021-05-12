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
        String sql ="select project from Project project";
        Query query=getSession().createQuery(sql,Project.class);
        List<Project> projectList=query.getResultList();
        System.out.println(projectList);
        closeTransactionSession();
        return projectList;
    }

    @Override
    public Project getById(long id) throws SQLException {
        openTransactionSession();
        String sql ="select project from Project project";
        Query query=getSession().createQuery(sql,Project.class);
        List<Project> projectList=query.getResultList();
        System.out.println(projectList);
        closeTransactionSession();
        return (Project)projectList.stream().filter((x) -> x.getId() == id).toArray()[0];
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