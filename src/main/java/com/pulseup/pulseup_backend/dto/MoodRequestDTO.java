package com.pulseup.pulseup_backend.dto;



public class MoodRequestDTO {
    private String name;
    private String description;

    
    public MoodRequestDTO() {
    }

    
    public MoodRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public String toString() {
        return "MoodRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
