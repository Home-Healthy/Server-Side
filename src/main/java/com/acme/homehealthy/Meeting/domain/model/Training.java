package com.acme.homehealthy.Meeting.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="rutine")
    private List<RoutineTraining> trainings;



    //Methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Training(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Training(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Training() {
    }


}
