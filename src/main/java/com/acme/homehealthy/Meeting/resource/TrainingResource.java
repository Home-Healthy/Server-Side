package com.acme.homehealthy.Meeting.resource;

public class TrainingResource {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TrainingResource setId(Long id) {
        this.id = id;
        return this;
    }

    public TrainingResource setName(String name) {
        this.name = name;
        return this;
    }

    public TrainingResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
