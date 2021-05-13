package com.ex.module.entities.actors;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@DiscriminatorValue("Company")
@Component
public class Company extends User{

    private String companyName;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @ManyToMany
    @JoinTable(
            name = "COLLABORATING",
            joinColumns =@JoinColumn(name = "COMPANY"),
            inverseJoinColumns =@JoinColumn(name = "DESIGNER")
    )
    private Set<Designer> designerSet;
    @ManyToMany
    @JoinTable(
            name = "DESIRE",
            joinColumns =@JoinColumn(name = "COMPANY"),
            inverseJoinColumns =@JoinColumn(name = "DESIGNER")
    )
    private Set<Designer> wantToCollaborate;


    public Company() {
        this.setRole("COMPANY");
    }
    public Company(String userName,String password){
        this();
        this.setUsername(userName);
        this.setPassword(password);
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
    public Set<Designer> getDesignerSet() {
        return designerSet;
    }
    //interaction function between company and designer
    //Set of collaboration
    public void addCollaboration(Designer designer){
        if(designerSet == null) designerSet=new HashSet<>();
        designerSet.add(designer);
    }
    public void addWantToCollaborate(Designer designer){
        if(wantToCollaborate == null) wantToCollaborate = new HashSet<>();
        wantToCollaborate.add(designer);
    }
    public void sendWantToCollaboration(Designer designer){
        designer.addWantToCollaborate(this);
    }
    public void acceptAllRequest(){
        if(wantToCollaborate != null) {
            wantToCollaborate.forEach((x) -> addCollaboration(x));
            wantToCollaborate.forEach((x) -> x.addCollaboration(this));
            wantToCollaborate = null;
        }
    }

    public Set<Designer> getWantToCollaborate() {
        return wantToCollaborate;
    }

    public void setWantToCollaborate(Set<Designer> wantToCollaborate) {
        this.wantToCollaborate = wantToCollaborate;
    }

    public void declineAllRequest(){wantToCollaborate=null;}
    public boolean acceptOneRequest(Designer designer){//need to create Exception if the object was not created
        if(wantToCollaborate.contains(designer)){
            addCollaboration(designer);
            wantToCollaborate.remove(designer);
            if(wantToCollaborate.isEmpty()){
                wantToCollaborate=null;
            }
            return true;
        }else{
            System.out.println("the designer doesn't have exist in wantToCollaborate");
            return false;
        }
    }
    public boolean declineOneRequest(Designer designer){
        if(wantToCollaborate.contains(designer)){
            wantToCollaborate.remove(designer);
            if(wantToCollaborate.isEmpty()){
                wantToCollaborate=null;
            }
            return true;
        }else{
            System.out.println("the designer doesn't have exist in wantToCollaborate");
            return false;
        }
    }
    public void sendRequestForCollaboration(Designer designer){
        designer.addWantToCollaborate(this);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
//                ", customerSet=" + customerSet +
//                ", designerSet=" + designerSet +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
