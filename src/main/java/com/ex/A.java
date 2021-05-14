package com.ex;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    public A(){}

    public A(String name){
        this.name=name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String str;


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
