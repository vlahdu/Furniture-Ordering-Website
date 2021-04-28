package com.ex.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.dao.CustomerDAO;
import com.ex.entities.actors.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public class CustomerService extends SessionUtil implements CustomerDAO {
    @Override
    public void addCustomer(Customer customer) throws SQLException {

        openTransactionSession();
        Session session=getSession();
        session.save(customer);
        closeTransactionSession();

    }

    @Override
    public List<Customer> getAll() throws SQLException {
        openTransactionSession();
        String sql="SELECT * FROM customer";
        Session session=getSession();
        Query query =session.createNativeQuery(sql).addEntity(Customer.class);
        List<Customer> designerList=query.list();
        closeTransactionSession();
        return designerList;
    }

    @Override
    public Customer getById(long id) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        String sql="SELECT * FROM customer WHERE ID = " + id ;
        Query query=session.createNativeQuery(sql).addEntity(Customer.class);
        Customer customer=(Customer)query.getSingleResult();
        closeTransactionSession();
        return customer;
    }

    @Override
    public void update(Customer customer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.update(customer);
        closeTransactionSession();
    }

    @Override
    public void remove(Customer customer) throws SQLException {
        openTransactionSession();
        Session session=getSession();
        session.remove(customer);
        closeTransactionSession();
    }
}