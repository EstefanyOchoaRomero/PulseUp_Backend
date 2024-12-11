package com.pulseup.pulseup_backend.dto;

public class RecommendationResponseDTO {
    private Long id;
    private String description;
    private String moodName; // Incluye el nombre del estado de ánimo asociado

    // Constructor vacío
    public RecommendationResponseDTO() {
    }

    // Constructor con parámetros
    public RecommendationResponseDTO(Long id, String description, String moodName) {
        this.id = id;
        this.description = description;
        this.moodName = moodName;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getMoodName() {
        return moodName;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    // toString
    @Override
    public String toString() {
        return "RecommendationResponseDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", moodName='" + moodName + '\'' +
                '}';
    }
}

