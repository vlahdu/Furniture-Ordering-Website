package com.fow.demo.service.detail;


import com.fow.demo.model.actors.Company;
import com.fow.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class CompanyDetailService implements UserDetailsService {
    @Autowired
    private CompanyService customerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Company company =customerService.findByUsername(userName);
        List<GrantedAuthority> authorities = getDesignerAuthority(company.getRole());
        return buildDesignerForAuthentication(company, authorities);
    }

    private List<GrantedAuthority> getDesignerAuthority(String role) {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role));
        return new ArrayList<>(roles);
    }
    private UserDetails buildDesignerForAuthentication(Company user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }

}