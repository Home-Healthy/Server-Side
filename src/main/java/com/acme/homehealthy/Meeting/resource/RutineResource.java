package com.acme.homehealthy.Meeting.resource;

public class RutineResource {

    private Long id;
    private String name;
    private String level;


    public Long getId() {
        return id;
    }

    public RutineResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RutineResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public RutineResource setLevel(String level) {
        this.level = level;
        return this;
    }
}
