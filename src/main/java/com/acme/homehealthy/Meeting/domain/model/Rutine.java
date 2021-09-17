package com.acme.homehealthy.Meeting.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="routines")
public class Rutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String level;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy ="training")
    private List<RoutineTraining> trainings;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;



    public Long getId() {
        return id;
    }

    public Rutine setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rutine setName(String name) {
        this.name = name;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Rutine setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public Rutine setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

/*
    @NotNull
    private String description;

    private String duration;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;

    public Long getId() {
        return id;
    }

    public Rutine setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rutine setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Rutine setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public Rutine setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Rutine setSession(Session session) {
        this.session = session;
        return this;
    }*/
}
