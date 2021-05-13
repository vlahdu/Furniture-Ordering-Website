package com.ex.module.entities.actors;

import com.ex.bl.SessionUtil;
import com.ex.module.entities.project.Project;
import com.ex.module.entityservices.DesignerService;
import org.hibernate.Session;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
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
    public void addCollaboration(Company company) throws SQLException {
        DesignerService designerService = new DesignerService();
        List<Designer> designers = designerService.getAll();
        designers.forEach((x) -> System.out.println(x.getCompanyCollaboration()));
        Designer designer = designerService.getById(id);
        if(designer.getCompanyCollaboration() ==null){
            designer.setCompanyCollaboration(new HashSet<>());
        }
        designer.getCompanyCollaboration().add(company);
        designerService.update(designer);
    }
    public void addWantToCollaborate(Company company) throws SQLException {
        DesignerService designerService = new DesignerService();
        if(wantToCollaborate == null) wantToCollaborate =new HashSet<>();
        wantToCollaborate.add(company);
    }
    public void sendWantToCollaboration(Company company){
        company.addWantToCollaborate(this);
    }
    public void acceptAllRequest(){
        if(wantToCollaborate != null) {
            SessionUtil sessionUtil= new SessionUtil();
            sessionUtil.openTransactionSession();
            Session session = sessionUtil.getSession();
            wantToCollaborate.forEach((x) -> {
                try {
                    addCollaboration(x);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            wantToCollaborate.forEach((x) -> x.addCollaboration(this));
            wantToCollaborate.forEach((x)->session.update(x));
            wantToCollaborate = null;
            session.update(this);
            sessionUtil.closeTransactionSession();
        }
    }
    public void declineAllRequest(){wantToCollaborate=null;}
    public boolean acceptOneRequest(Company company) throws SQLException {//need to create Exception if the object was not created
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
        SessionUtil sessionUtil= new SessionUtil();
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        company.addWantToCollaborate(this);
        session.update(this);
        session.update(company);
        sessionUtil.closeTransactionSession();
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
