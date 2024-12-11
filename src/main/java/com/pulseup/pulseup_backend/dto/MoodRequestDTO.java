package com.pulseup.pulseup_backend.dto;



public class MoodRequestDTO {
    private String name; // Nombre del estado de ánimo
    private String description; // Descripción opcional del estado de ánimo

    // Constructor vacío
    public MoodRequestDTO() {
    }

    // Constructor con parámetros
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString() {
        return "MoodRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
