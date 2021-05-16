package com.fow.demo.repository;


import com.fow.demo.model.actors.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserName(String userName);
    Customer findByEmail(String email);
}
