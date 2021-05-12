package com.ex.module.dao;

import com.ex.module.entities.actors.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * @author IonToncu
 */
public interface CompanyDAO {
<<<<<<< HEAD:src/main/java/com/ex/dao/CompanyDAO.java

=======
>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31:src/main/java/com/ex/module/dao/CompanyDAO.java
    void addCompany(Company company)throws SQLException;
    List<Company> getAll()throws SQLException;
    Company getById(long id)throws SQLException;
    void update(Company company)throws SQLException;
    void remove(Company company)throws SQLException;
}
