package com.ex.module.entities.project;
import org.springframework.stereotype.Component;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Sofa")
@Component
public class Sofa extends Project{
    private String dimension;
    private String upholstered;
    private String color;
    private String structure;
    private String suspension;
    private String sitings;
    private String records;
    private String Armrests;
    private String base;
    private String included;

    public Sofa() {

    }
    public Sofa(String name,String description) {
        this.setName(name);
        this.setDescription(description);
    }
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getUpholstered() {
        return upholstered;
    }

    public void setUpholstered(String upholstered) {
        this.upholstered = upholstered;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public String getSitings() {
        return sitings;
    }

    public void setSitings(String sitings) {
        this.sitings = sitings;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getArmrests() {
        return Armrests;
    }

    public void setArmrests(String armrests) {
        Armrests = armrests;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getIncluded() {
        return included;
    }

    public void setIncluded(String included) {
        this.included = included;
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coating='" + coating + '\'' +
                ", price=" + price +
 //               ", designer=" + designer +
                ", dimension='" + dimension + '\'' +
                ", upholstered='" + upholstered + '\'' +
                ", color='" + color + '\'' +
                ", structure='" + structure + '\'' +
                ", suspension='" + suspension + '\'' +
                ", sitings='" + sitings + '\'' +
                ", records='" + records + '\'' +
                ", Armrests='" + Armrests + '\'' +
                ", base='" + base + '\'' +
                ", included='" + included + '\'' +
                '}';
    }
}
