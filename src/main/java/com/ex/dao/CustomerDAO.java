package com.ex.dao;

import com.ex.entities.actors.Customer;

import java.sql.SQLException;
import java.util.List;

/*
 * @IonToncu
 *
 * */
interface CustomerDAO {
    void addCustomer(Customer customer)throws SQLException;
    List<Customer> getAll()throws SQLException;
    Customer getById(long id)throws SQLException;
    void update(Customer customer)throws SQLException;
    void remove(Customer customer)throws SQLException;
}

