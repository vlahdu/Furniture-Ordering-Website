package com.fow.demo.repository;


import com.fow.demo.model.actors.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByUserName(String userName);
    Company findById(long id);
    Company findByEmail(String email);
    List<Company> findAll();
}
