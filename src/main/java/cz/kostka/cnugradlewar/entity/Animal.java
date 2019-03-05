package cz.kostka.cnugradlewar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Animal(){
    }

    public Animal(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Animal(String name, String description){
        this.name = name;
        this.description = description;
    }
}
