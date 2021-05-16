package com.fow.demo.service.detail;


import com.fow.demo.model.actors.Customer;
import com.fow.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class CustomerDetailService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer =customerService.findByUsername(userName);
        List<GrantedAuthority> authorities = getDesignerAuthority(customer.getRole());
        return buildDesignerForAuthentication(customer, authorities);
    }

    private List<GrantedAuthority> getDesignerAuthority(String role) {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role));
        return new ArrayList<>(roles);
    }
    private UserDetails buildDesignerForAuthentication(Customer user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }

}