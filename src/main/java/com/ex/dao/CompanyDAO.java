package com.ex.dao;

import com.ex.entities.actors.Company;

import java.sql.SQLException;
import java.util.List;

/*
 * @IonToncu
 *
 * */
public interface CompanyDAO {

    void addCompany(Company company)throws SQLException;
    List<Company> getAll()throws SQLException;
    Company getById(long id)throws SQLException;
    void update(Company company)throws SQLException;
    void remove(Company company)throws SQLException;
}
