package com.ex.module.entities.project;
import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TableAndChairs")
@Component
public class TableAndChairs extends Project{
    private String dimensions;
    private String cover;
    private String packing;
    private String structure;
    private String base;


    public TableAndChairs(String name,String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public TableAndChairs() {
    }
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "TableAndChairs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coating='" + coating + '\'' +
                ", price=" + price +
//                ", designer=" + designer +
                ", dimensions='" + dimensions + '\'' +
                ", cover='" + cover + '\'' +
                ", packing='" + packing + '\'' +
                ", structure='" + structure + '\'' +
                ", base='" + base + '\'' +
                '}';
    }
}
