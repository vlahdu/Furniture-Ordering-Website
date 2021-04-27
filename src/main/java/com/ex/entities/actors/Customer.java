package com.ex.entities.actors;

import com.ex.entities.project.Project;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project>likedProjects;
    private String name;

    public Set<Project> getLikedProjects() {
        return likedProjects;
    }

    public void setLikedProjects(Set<Project> likedProjects) {
        this.likedProjects = likedProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
