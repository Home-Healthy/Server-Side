package com.acme.homehealthy.Meeting.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveRutineResource {

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Size(max = 20)
    private String level;

    public String getLevel() {
        return level;
    }

    public SaveRutineResource setLevel(String level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveRutineResource setName(String name) {
        this.name = name;
        return this;
    }


}
