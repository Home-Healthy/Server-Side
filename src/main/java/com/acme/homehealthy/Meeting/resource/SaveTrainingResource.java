package com.acme.homehealthy.Meeting.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveTrainingResource {

    @NotNull
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message="Description must have between 3 and 20 characters")
    private String description;

    public String getName() {
        return name;
    }

    public SaveTrainingResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveTrainingResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
