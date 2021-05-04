package com.ex.entities.actors;

import javax.persistence.*;
import java.util.Set;
/**
 * @author IonToncu
 */
@Entity
public class Company extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
        this.role="COMPANY";
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
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

    public void setId(Long id) {
        this.id = id;
    }


}
