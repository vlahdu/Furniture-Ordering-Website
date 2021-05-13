package com.ex.module.dao;

import com.ex.module.entities.actors.Customer;

import java.sql.SQLException;
import java.util.List;

/*
 * @vlahdu
 *
 * */
public interface CustomerDAO {
    boolean addCustomer(Customer customer)throws SQLException;
    List<Customer> getAll()throws SQLException;
    Customer getById(long id)throws SQLException;
    void update(Customer customer)throws SQLException;
    void remove(Customer customer)throws SQLException;
}
