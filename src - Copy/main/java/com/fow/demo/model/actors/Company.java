package com.fow.demo.model.actors;


import com.fow.demo.model.projects.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@DiscriminatorValue("COMPANY")
@Component
public class Company extends User {
    private String companyName;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customerSet;
    @ManyToMany
    @JoinTable(
            name = "COLLABORATING",
            joinColumns = @JoinColumn(name = "COMPANY"),
            inverseJoinColumns = @JoinColumn(name = "DESIGNER")
    )
    private Set<Designer> designerSet;
    @ManyToMany
    @JoinTable(
            name = "DESIRE",
            joinColumns = @JoinColumn(name = "COMPANY"),
            inverseJoinColumns = @JoinColumn(name = "DESIGNER")
    )
    private Set<Designer> wantToCollaborate;
    @ManyToMany
    private Map<Customer,Project> wantBuyProject;

    public boolean addWillingToCollaborate(Designer designer){
        if(wantToCollaborate == null) wantToCollaborate= new HashSet<>();
        wantToCollaborate.add(designer);
        return true;
    }

    public Set<Designer> getWantToCollaborate() {
        return wantToCollaborate;
    }

    public Map<Customer, Project> getWantBuyProject() {
        return wantBuyProject;
    }

    public void setWantBuyProject(Map<Customer, Project> wantBuyProject) {
        this.wantBuyProject = wantBuyProject;
    }
}








