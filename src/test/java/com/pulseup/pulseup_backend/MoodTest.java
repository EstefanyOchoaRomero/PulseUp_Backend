package com.pulseup.pulseup_backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.models.Recommendation;

public class MoodTest {

    @Test
    public void testConstructor() {
        Mood mood = new Mood();
        assertNotNull(mood);
    }

    @Test
    public void testGetId() {
        Mood mood = new Mood();
        mood.setId(1L);
        assertEquals(1L, mood.getId());
    }

    @Test
    public void testGetName() {
        Mood mood = new Mood();
        mood.setName("Ansioso");
        assertEquals("Ansioso", mood.getName());
    }

    @Test
    public void testGetRecommendations() {
        Mood mood = new Mood();
        Recommendation recommendation = new Recommendation();
        mood.getRecommendations().add(recommendation);
        assertEquals(1, mood.getRecommendations().size());
    }

    @Test
    public void testSetRecommendations() {
        Mood mood = new Mood();
        List<Recommendation> recommendations = new ArrayList<>();
        Recommendation recommendation = new Recommendation();
        recommendations.add(recommendation);
        mood.setRecommendations(recommendations);
        assertEquals(1, mood.getRecommendations().size());
    }



}
