package com.fow.demo.service.detail;

import com.fow.demo.model.actors.Designer;
import com.fow.demo.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class DesignerDetailService implements UserDetailsService {
    @Autowired
    DesignerService designerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Designer designer =designerService.findByUsername(userName);
        List<GrantedAuthority> authorities = getDesignerAuthority(designer.getRole());
        return buildDesignerForAuthentication(designer, authorities);
    }

    private List<GrantedAuthority> getDesignerAuthority(String role) {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(role));
        return new ArrayList<>(roles);
    }
    private UserDetails buildDesignerForAuthentication(Designer user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }

}
