package com.ex.module.entities.actors;

import com.ex.module.entities.project.Project;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;
/**
 * @author IonToncu
 */
@Entity
<<<<<<< HEAD:src/main/java/com/ex/entities/actors/Customer.java
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
=======
@DiscriminatorValue("Customer")
@Component
public class Customer extends User {

>>>>>>> 737e9d5dcd0061baa74e8227406c016619ba4d31:src/main/java/com/ex/module/entities/actors/Customer.java
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project>likedProjects;
    private String name;

    public Customer() {
        this.role="CUSTOMER";
    }

    public Set<Project> getLikedProjects() {
        return likedProjects;
    }
    public Customer() {
        this.setRole("CUSTOMER");
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
