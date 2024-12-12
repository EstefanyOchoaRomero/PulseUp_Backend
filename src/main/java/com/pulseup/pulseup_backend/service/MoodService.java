package com.pulseup.pulseup_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.models.Recommendation;
import com.pulseup.pulseup_backend.repository.MoodRepository;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public List<Recommendation> getRecommendations(String moodName) {
        Mood mood = moodRepository.findByName(moodName)
                .orElseThrow(() -> new IllegalArgumentException("Mood not found: " + moodName));
        return mood.getRecommendations();
    }

    public Mood findByName(String name) {
        return moodRepository.findByName(name).orElse(null);
    }
    
    public Mood saveMood(Mood mood) {
        return moodRepository.save(mood);
    }

    public Mood updateMood(Long id, Mood moodDetails) {
        
        Mood existingMood = moodRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mood not found with id: " + id));

        
        existingMood.setName(moodDetails.getName());
        

        
        return moodRepository.save(existingMood);
    }

    public Mood findById(Long id) {
        return moodRepository.findById(id).orElse(null);
    }

    public void deleteMood(Long id) {
        moodRepository.deleteById(id);
    }


    
}
