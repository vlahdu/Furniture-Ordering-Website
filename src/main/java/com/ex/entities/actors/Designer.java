package com.ex.entities.actors;

import com.ex.entities.project.Project;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Designer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Company> companyCollaboration;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project> ownProjects;
    public Designer(){
        this.role="DESIGNER";
    }

    public Set<Company> getCompanyCollaboration() {
        return companyCollaboration;
    }

    public void setCompanyCollaboration(Set<Company> companyCollaboration) {
        this.companyCollaboration = companyCollaboration;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Set<Project> getOwnProjects() {
        return ownProjects;
    }

    public void setOwnProjects(Set<Project> ownProjects) {
        this.ownProjects = ownProjects;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
