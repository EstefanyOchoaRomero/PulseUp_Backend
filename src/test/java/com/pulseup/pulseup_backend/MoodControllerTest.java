package com.pulseup.pulseup_backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.pulseup.pulseup_backend.controller.MoodController;
import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.service.MoodService;

@ExtendWith(MockitoExtension.class)
public class MoodControllerTest {

    @Mock
    private MoodService moodService;

    @InjectMocks
    private MoodController moodController;

    @Test
    public void testGetRecommendations() {
        
        Mood mood = new Mood();
        mood.setName("Ansioso");
        when(moodService.findByName(any())).thenReturn(mood);

        
        ResponseEntity<?> response = moodController.getRecommendations("Ansioso");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testGetRecommendationsNotFound() {
        
        when(moodService.findByName(any())).thenReturn(null);

    
        ResponseEntity<?> response = moodController.getRecommendations("Ansioso");

        
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testSaveMood() {
        
        Mood mood = new Mood();
        mood.setName("Ansioso");
        when(moodService.saveMood(any())).thenReturn(mood);

        
        ResponseEntity<?> response = moodController.saveMood(mood);

        
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testSaveMoodBadRequest() {
        
        Mood mood = new Mood();

        
        ResponseEntity<?> response = moodController.saveMood(mood);

        
        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateMood() {
        
        Mood mood = new Mood();
        mood.setId(1L);
        mood.setName("Ansioso");
        when(moodService.findById(anyLong())).thenReturn(mood);
        when(moodService.updateMood(anyLong(), any())).thenReturn(mood);

        
        ResponseEntity<?> response = moodController.updateMood(1L, mood);

        
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateMoodNotFound() {
        
        when(moodService.findById(anyLong())).thenReturn(null);

        
        ResponseEntity<?> response = moodController.updateMood(1L, new Mood());

        
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteMood() {
        
        Mood mood = new Mood();
        mood.setId(1L);
        when(moodService.findById(anyLong())).thenReturn(mood);

    
        ResponseEntity<Void> response = moodController.deleteMood(1L);

        
        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteMoodNotFound() {
        
        when(moodService.findById(anyLong())).thenReturn(null);

        
        ResponseEntity<Void> response = moodController.deleteMood(1L);

        
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testGetMood() {
        
        Mood mood = new Mood();
        mood.setId(1L);
        mood.setName("Ansioso");
        when(moodService.findById(anyLong())).thenReturn(mood);

        
        ResponseEntity<?> response = moodController.getMood(1L);

    
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testGetMoodNotFound() {
        
        when(moodService.findById(anyLong())).thenReturn(null);

        
        ResponseEntity<?> response = moodController.getMood(1L);

        
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
    }
}
