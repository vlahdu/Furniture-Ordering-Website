package com.ex.dao;

import com.ex.entities.actors.Company;

import java.sql.SQLException;
import java.util.List;

/*
 * @IonToncu
 *
 * */
public interface CompanyDAO {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> IonToncu
=======
>>>>>>> 560879f4e7313fca9f38b2480cab9f11aca4f726
    void addCompany(Company company)throws SQLException;
    List<Company> getAll()throws SQLException;
    Company getById(long id)throws SQLException;
    void update(Company company)throws SQLException;
    void remove(Company company)throws SQLException;
}
