package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.CompanyDAO;
import com.ex.module.entities.actors.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CompanyService extends SessionUtil implements CompanyDAO {
    @Override
    public void addCompany(Company company) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.save(company);
        closeTransactionSession();

    }

    @Override
    public List<Company> getAll() throws SQLException {
        openTransactionSession();
        String sql ="select company from Company company";
        Query query=getSession().createQuery(sql,Company.class);
        List<Company> companyList=query.getResultList();
        System.out.println(companyList);
        closeTransactionSession();
        return companyList;
    }

    @Override
    public Company getById(long id) throws SQLException {
        openTransactionSession();
        String sql ="select company from Company company";
        Query query=getSession().createQuery(sql,Company.class);
        List<Company> companyList=query.getResultList();
        System.out.println(companyList);
        closeTransactionSession();
        return (Company)companyList.stream().filter((x) -> x.getId() == id).toArray()[0];
    }

    @Override
    public void update(Company company) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(company);
        closeTransactionSession();
    }

    @Override
    public void remove(Company company) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(company);
        closeTransactionSession();
    }
}