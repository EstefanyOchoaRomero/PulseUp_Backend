package com.pulseup.pulseup_backend.dto;

public class RecommendationResponseDTO {
    private Long id;
    private String description;
    private String moodName;

    
    public RecommendationResponseDTO() {
    }

    
    public RecommendationResponseDTO(Long id, String description, String moodName) {
        this.id = id;
        this.description = description;
        this.moodName = moodName;
    }

    
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getMoodName() {
        return moodName;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    
    @Override
    public String toString() {
        return "RecommendationResponseDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", moodName='" + moodName + '\'' +
                '}';
    }
}

