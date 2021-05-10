package com.ex.module.entities.actors;

import com.ex.module.entities.project.Project;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("Customer")
@Component
public class Customer extends User {

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

    @Override
    public String toString() {
        return "Customer{" +
                ", name='" + name + '\'' +
                '}';
    }

}
