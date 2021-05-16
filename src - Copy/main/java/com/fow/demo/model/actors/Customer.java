package com.fow.demo.model.actors;


import com.fow.demo.model.projects.Project;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("CUSTOMER")
@Component
public class Customer extends User {
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Project> likedProjects;

    public boolean addLikedProject(Project project){
        if(likedProjects == null) likedProjects= new HashSet<>();
        likedProjects.add(project);
        return true;
    }

    public Set<Project> getLikedProjects() {
        return likedProjects;
    }

    public void setLikedProjects(Set<Project> likedProjects) {
        this.likedProjects = likedProjects;
    }
}














