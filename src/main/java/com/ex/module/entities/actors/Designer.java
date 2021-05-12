package com.ex.module.entities.actors;

import com.ex.module.entities.project.Project;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Designer")
@Component
public class Designer extends User {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Company> companyCollaboration;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project> ownProjects;

    public Set<Company> getCompanyCollaboration() {
        return companyCollaboration;
    }
    public Designer(){
        this.setRole("DESIGNER");
    }
    public Designer(String userName,String password){
        this();
        this.setPassword(password);
        this.setUsername(userName);
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

    public void  addProject(Project project){
        if(ownProjects == null) ownProjects=new HashSet<>();
        ownProjects.add(project);
    }

    @Override
    public String toString() {
        return "Designer{" +
                "companyCollaboration=" + companyCollaboration +
                ", customerSet=" + customerSet +
                ", ownProjects=" + ownProjects +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
