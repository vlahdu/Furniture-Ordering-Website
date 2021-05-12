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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COLLABORATING_BETWEEN_COMP_AND_DES",
            joinColumns ={@JoinColumn(name = "COMPANY")},
            inverseJoinColumns ={@JoinColumn(name = "DESIGNER")}
    )
    private Set<Designer> designerSet;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "DESIRE TO_COLLABORATING_BETWEEN_COMP_AND_DES",
            joinColumns ={@JoinColumn(name = "COMPANY")},
            inverseJoinColumns ={@JoinColumn(name = "DESIGNER")}
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
    private void addCollaboration(Designer designer){
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
            wantToCollaborate = null;
        }
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
                ", customerSet=" + customerSet +
                ", designerSet=" + designerSet +
                ", wantToCollaborate=" + wantToCollaborate +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
