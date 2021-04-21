package com.ex.entities.actors;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
