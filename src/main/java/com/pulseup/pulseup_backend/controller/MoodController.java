package com.pulseup.pulseup_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.service.MoodService;

@RestController
@RequestMapping("/api/moods")
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    
    @GetMapping("/{moodName}/recommendations")
    public ResponseEntity<?> getRecommendations(@PathVariable String moodName) {

        Mood mood = moodService.findByName(moodName);
        if (mood == null) {
            return ResponseEntity.status(404).body("Mood not found with name: " + moodName);
        }

        return ResponseEntity.ok(moodService.getRecommendations(moodName));
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveMood(@RequestBody Mood mood) {

        if (mood.getName() == null || mood.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Mood name is required.");
        }

        Mood existingMood = moodService.findByName(mood.getName());
        if (existingMood != null) {
            return ResponseEntity.status(409).body("Mood with the name already exists: " + mood.getName());
        }

        
        Mood savedMood = moodService.saveMood(mood);
        return ResponseEntity.ok(savedMood);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mood> updateMood(@PathVariable Long id, @RequestBody Mood moodDetails) {

        Mood existingMood = moodService.findById(id);
        if (existingMood == null) {
            return ResponseEntity.notFound().build();
        }

        Mood updatedMood = moodService.updateMood(id, moodDetails);

        return ResponseEntity.ok(updatedMood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMood(@PathVariable Long id) {

        Mood existingMood = moodService.findById(id);
        if (existingMood == null) {
            return ResponseEntity.notFound().build();
        }

        moodService.deleteMood(id);

        return ResponseEntity.noContent().build();
    }

}
