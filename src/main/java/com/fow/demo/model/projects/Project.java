package com.fow.demo.model.projects;




import com.fow.demo.model.actors.Designer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCoating() {
        return coating;
    }

    public void setCoating(String coating) {
        this.coating = coating;
    }

    public double getPrice() {
        return price;
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
}
