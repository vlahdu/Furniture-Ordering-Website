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

    @ManyToMany(mappedBy = "designerSet")
    private Set<Company> companyCollaboration;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project> ownProjects;
    @ManyToMany(mappedBy = "wantToCollaborate")
    private Set<Company> wantToCollaborate =null;

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
    //add single project
    public void  addProject(Project project){
        if(ownProjects == null) ownProjects=new HashSet<>();
        ownProjects.add(project);
        project.setDesigner(this);
    }
    //interaction function between company and designer
    //Set of collaboration
    public void addCollaboration(Company company){
        if(companyCollaboration == null) companyCollaboration=new HashSet<>();
        companyCollaboration.add(company);
    }
    public void addWantToCollaborate(Company company){
        if(wantToCollaborate == null) wantToCollaborate =new HashSet<>();
        wantToCollaborate.add(company);
    }
    public void sendWantToCollaboration(Company company){
        company.addWantToCollaborate(this);
    }
    public void acceptAllRequest(){
        if(wantToCollaborate != null) {
            wantToCollaborate.forEach((x) -> addCollaboration(x));
            wantToCollaborate.forEach((x) -> x.addCollaboration(this));
            wantToCollaborate = null;
        }
    }
    public void declineAllRequest(){wantToCollaborate=null;}
    public boolean acceptOneRequest(Company company){//need to create Exception if the object was not created
        if(wantToCollaborate.contains(company)){
            addCollaboration(company);
            wantToCollaborate.remove(company);
            if(wantToCollaborate.isEmpty()){
                wantToCollaborate=null;
            }
            return true;
        }else{
            System.out.println("the company doesn't have exist in wantToCollaborate");
            return false;
        }
    }
    public boolean declineOneRequest(Company company){
        if(wantToCollaborate.contains(company)){
            wantToCollaborate.remove(company);
            if(wantToCollaborate.isEmpty()){
                wantToCollaborate=null;
            }
            return true;
        }else{
            System.out.println("the company doesn't have exist in wantToCollaborate");
            return false;
        }
    }
    public void sendRequestForCollaboration(Company company){
        company.addWantToCollaborate(this);
    }
    public void addCustomer(Customer customer){
        if(customerSet == null) customerSet= new HashSet<>();
        customerSet.add(customer);
    }
    public Set<Company> getWantToCollaborate() {
        return wantToCollaborate;
    }
    public void setWantToCollaborate(Set<Company> wantToCollaborate) {
        this.wantToCollaborate = wantToCollaborate;
    }


    @Override
    public String toString() {
        return "Designer{" +
//                "companyCollaboration=" + companyCollaboration +
//                ", customerSet=" + customerSet +
//                ", ownProjects=" + ownProjects +
//                ", wantToCollaborate=" + wantToCollaborate +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
