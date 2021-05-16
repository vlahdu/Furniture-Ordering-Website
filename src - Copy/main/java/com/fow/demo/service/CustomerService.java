package com.fow.demo.service;
import com.fow.demo.model.actors.Customer;
import com.fow.demo.model.actors.Designer;
import com.fow.demo.repository.CustomerRepository;
import com.fow.demo.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public Customer findDesignerByEmail(String email){
        return customerRepository.findByEmail(email);
    }
    public Customer findByUsername(String username){
        return customerRepository.findByUserName(username);
    }
    public Customer saveCustomer(Customer customer){
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setActive(true);
        customer.setRole("CUSTOMER");
        return customerRepository.save(customer);
    }

}
