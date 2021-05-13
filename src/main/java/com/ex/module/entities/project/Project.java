package com.ex.module.entities.project;


import com.ex.module.entities.actors.Designer;

import javax.persistence.*;
/**
 * @author IonToncu
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING )
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  Long id;
    protected String name;
    @Column(length = 500)
    protected String description;
    protected String coating;
    protected double price;
    @ManyToOne(cascade = CascadeType.ALL)
    protected Designer designer;

    public Project() {
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getCoating() {
        return coating;
    }

    public void setCoating(String coating) {
        this.coating = coating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coating='" + coating + '\'' +
                ", price=" + price +
                ", designer=" + designer +
                '}';
    }
}
