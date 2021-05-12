package com.ex.module.entityservices;

import com.ex.bl.SessionUtil;
import com.ex.module.dao.CustomerDAO;
import com.ex.module.entities.actors.Customer;
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
        String sql ="select customer from Customer customer";
        Query query=getSession().createQuery(sql,Customer.class);
        List<Customer> customerList=query.getResultList();
        System.out.println(customerList);
        closeTransactionSession();
        return customerList;
    }

    @Override
    public Customer getById(long id) throws SQLException {
        openTransactionSession();
        String sql ="select customer from Customer customer";
        Query query=getSession().createQuery(sql,Customer.class);
        List<Customer> customerList=query.getResultList();
        System.out.println(customerList);
        closeTransactionSession();
        return (Customer)customerList.stream().filter((x) -> x.getId() == id).toArray()[0];
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