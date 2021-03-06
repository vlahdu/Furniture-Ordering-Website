package com.fow.demo.model.actors;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
