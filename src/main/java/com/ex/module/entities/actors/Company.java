package com.ex.module.entities.actors;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;
/**
 * @author IonToncu
 */
@Entity
<<<<<<< HEAD:src/main/java/com/ex/entities/actors/Company.java
public class Company extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
=======
@DiscriminatorValue("Company")
@Component
public class Company extends User{

>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31:src/main/java/com/ex/module/entities/actors/Company.java
    private String companyName;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COLLABORATING_BETWEEN_COMP_AND_DES",
            joinColumns ={@JoinColumn(name = "COMPANY")},
            inverseJoinColumns ={@JoinColumn(name = "DESIGNER")}
    )
    private Set<Designer> designerSet;

    public Company() {
<<<<<<< HEAD:src/main/java/com/ex/entities/actors/Company.java
        this.role="COMPANY";
    }


    public long getId() {
        return id;
=======
        this.setRole("COMPANY");
>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31:src/main/java/com/ex/module/entities/actors/Company.java
    }

    public String getName() {
        return companyName;
    }

    public void setName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<Designer> getDesignerSet() {
        return designerSet;
    }

    public void setDesignerSet(Set<Designer> designerSet) {
        this.designerSet = designerSet;
    }




}
