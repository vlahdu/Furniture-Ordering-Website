package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.CompanyDAO;
import com.ex.module.entities.actors.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
/**
 * @author IonToncu
 */
public class CompanyService extends SessionUtil implements CompanyDAO {
    @Override
    public void addCompany(Company company) throws SQLException {
<<<<<<< HEAD:src/main/java/com/ex/entityservices/CompanyService.java

=======
>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31:src/main/java/com/ex/module/entityservices/CompanyService.java
        openTransactionSession();
        Session session=getSession();
        session.save(company);
        closeTransactionSession();

    }

    @Override
    public List<Company> getAll() throws SQLException {
        openTransactionSession();
        String sql="SELECT * FROM company";
        Session session=getSession();
        Query query =session.createNativeQuery(sql).addEntity(Company.class);
        List<Company> designerList=query.list();
        closeTransactionSession();
        return designerList;
    }

    @Override
    public Company getById(long id) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        String sql="SELECT * FROM company WHERE ID = " + id ;
        Query query=session.createNativeQuery(sql).addEntity(Company.class);
        Company company=(Company)query.getSingleResult();
        closeTransactionSession();
        return company;
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