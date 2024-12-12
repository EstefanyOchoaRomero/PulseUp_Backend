package com.pulseup.pulseup_backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.models.Recommendation;

public class RecommendationTest {

    @Test
    public void testConstructor() {
        Recommendation recommendation = new Recommendation();
        assertNotNull(recommendation);
    }

    @Test
    public void testGetId() {
        Recommendation recommendation = new Recommendation();
        recommendation.setId(1L);
        assertEquals(1L, recommendation.getId());
    }

    @Test
    public void testGetDescription() {
        Recommendation recommendation = new Recommendation();
        recommendation.setDescription("Ejercicio físico");
        assertEquals("Ejercicio físico", recommendation.getDescription());
    }

    @Test
    public void testGetMood() {
        Recommendation recommendation = new Recommendation();
        Mood mood = new Mood();
        mood.setId(1L);
        mood.setName("Ansioso");
        recommendation.setMood(mood);
        assertEquals(mood, recommendation.getMood());
    }

    @Test
    public void testSetMood() {
        Recommendation recommendation = new Recommendation();
        Mood mood = new Mood();
        mood.setId(1L);
        mood.setName("Ansioso");
        recommendation.setMood(mood);
        assertEquals(mood, recommendation.getMood());
    }



}
