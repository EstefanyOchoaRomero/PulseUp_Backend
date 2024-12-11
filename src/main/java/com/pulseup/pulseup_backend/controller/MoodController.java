package com.pulseup.pulseup_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return ResponseEntity.ok(moodService.getRecommendations(moodName));
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveMood(@RequestBody Mood mood) {
        return ResponseEntity.ok(moodService.saveMood(mood));
    }
}
