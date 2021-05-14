package com.ex.module.entities.actors;

import com.ex.module.entities.project.Project;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * @author IonToncu
 */
@Entity

public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project>likedProjects;
    private String name;
    public Customer() {
        this.setRole("CUSTOMER");
    }
    public Customer(String name,String password){
        this();
        this.setUsername(username);
        this.setPassword(password);
    }
    public void setLikedProjects(Set<Project> likedProjects) {
        this.likedProjects = likedProjects;
    }
    public Set<Project> getLikedProjects() {
        return likedProjects;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addLikedProject(Project project){
        if(likedProjects == null) likedProjects =new HashSet<>();
        project.getDesigner().addCustomer(this);//add customer to customerSet
        likedProjects.add(project);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "likedProjects=" + likedProjects +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
