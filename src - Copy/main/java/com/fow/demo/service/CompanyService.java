package com.fow.demo.service;

import com.fow.demo.model.actors.Company;
import com.fow.demo.model.actors.Customer;
import com.fow.demo.repository.CompanyRepository;
import com.fow.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.companyRepository = companyRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public Company findDesignerByEmail(String email){
        return companyRepository.findByEmail(email);
    }
    public Company findById(long id){
        return companyRepository.findById(id);
    }
    public Company findByUsername(String username){
        return companyRepository.findByUserName(username);
    }
    public Company saveCompany(Company company){
        company.setPassword(bCryptPasswordEncoder.encode(company.getPassword()));
        company.setActive(true);
        company.setRole("COMPANY");
        return companyRepository.save(company);
    }
    public List<Company> findAll(){return companyRepository.findAll();}
}
