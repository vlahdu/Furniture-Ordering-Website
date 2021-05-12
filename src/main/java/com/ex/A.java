package com.ex;

public class A {
<<<<<<< HEAD
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
=======
    private String str;
>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
