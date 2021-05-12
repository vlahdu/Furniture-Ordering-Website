package com.ex.module.entities.project;

import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Armchairs")
@Component
public class Armchairs extends Project{
    private String dimension;
    private String plainCoating;
    private String materialCoating;
    private String seat;
    private String base;

    public Armchairs(){}
    public Armchairs(String name,String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getPlainCoating() {
        return plainCoating;
    }

    public void setPlainCoating(String plainCoating) {
        this.plainCoating = plainCoating;
    }

    public String getMaterialCoating() {
        return materialCoating;
    }

    public void setMaterialCoating(String materialCoating) {
        this.materialCoating = materialCoating;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Armchairs{" +
                "dimension='" + dimension + '\'' +
                ", plainCoating='" + plainCoating + '\'' +
                ", materialCoating='" + materialCoating + '\'' +
                ", seat='" + seat + '\'' +
                ", base='" + base + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coating='" + coating + '\'' +
                ", price=" + price +
                ", designer=" + designer +
                '}';
    }
}
