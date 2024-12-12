package com.pulseup.pulseup_backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pulseup.pulseup_backend.models.Mood;
import com.pulseup.pulseup_backend.models.Recommendation;
import com.pulseup.pulseup_backend.repository.MoodRepository;
import com.pulseup.pulseup_backend.service.MoodService;

class MoodServiceTest {

    @Mock
    private MoodRepository moodRepository;

    @InjectMocks
    private MoodService moodService;

    private Mood mood;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mood = new Mood();
        mood.setName("Happy");
        Recommendation smile = new Recommendation();
        smile.setDescription("Smile");
        Recommendation dance = new Recommendation();
        dance.setDescription("Dance");
        mood.setRecommendations(Arrays.asList(smile, dance));
    }

    @Test
    void testGetRecommendations() {
    
        String moodName = "Happy";
        when(moodRepository.findByName(moodName)).thenReturn(Optional.of(mood));

        
        var recommendations = moodService.getRecommendations(moodName);

        
        assertNotNull(recommendations);
        assertEquals(2, recommendations.size());
        assertEquals("Smile", recommendations.get(0).getDescription());
        verify(moodRepository, times(1)).findByName(moodName);
    }

    @Test
    void testGetRecommendations_MoodNotFound() {
        
        String moodName = "Sad";
        when(moodRepository.findByName(moodName)).thenReturn(Optional.empty());

        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moodService.getRecommendations(moodName);
        });
        assertEquals("Mood not found: Sad", exception.getMessage());
        verify(moodRepository, times(1)).findByName(moodName);
    }

    @Test
    void testFindByName() {
        
        when(moodRepository.findByName("Happy")).thenReturn(Optional.of(mood));

        Mood foundMood = moodService.findByName("Happy");

        assertNotNull(foundMood);
        assertEquals("Happy", foundMood.getName());
        verify(moodRepository, times(1)).findByName("Happy");
    }

    @Test
    void testFindByName_MoodNotFound() {
        
        when(moodRepository.findByName("Sad")).thenReturn(Optional.empty());

        Mood foundMood = moodService.findByName("Sad");

        
        assertNull(foundMood);
        verify(moodRepository, times(1)).findByName("Sad");
    }

    @Test
    void testSaveMood() {
        
        when(moodRepository.save(mood)).thenReturn(mood);

        
        Mood savedMood = moodService.saveMood(mood);

        
        assertNotNull(savedMood);
        assertEquals("Happy", savedMood.getName());
        verify(moodRepository, times(1)).save(mood);
    }

    @Test
    void testUpdateMood() {
        
        Long moodId = 1L;
        Mood updatedMood = new Mood();
        updatedMood.setName("Excited");

        when(moodRepository.findById(moodId)).thenReturn(Optional.of(mood));
        when(moodRepository.save(mood)).thenReturn(mood);

        
        Mood result = moodService.updateMood(moodId, updatedMood);

        
        assertNotNull(result);
        assertEquals("Excited", result.getName());
        verify(moodRepository, times(1)).findById(moodId);
        verify(moodRepository, times(1)).save(mood);
    }

    @Test
    void testUpdateMood_MoodNotFound() {
        
        Long moodId = 1L;
        Mood updatedMood = new Mood();
        updatedMood.setName("Excited");

        when(moodRepository.findById(moodId)).thenReturn(Optional.empty());

        
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            moodService.updateMood(moodId, updatedMood);
        });
        assertEquals("Mood not found with id: 1", exception.getMessage());
        verify(moodRepository, times(1)).findById(moodId);
    }

    @Test
    void testFindById() {
        
        Long moodId = 1L;
        when(moodRepository.findById(moodId)).thenReturn(Optional.of(mood));

        
        Mood foundMood = moodService.findById(moodId);

        
        assertNotNull(foundMood);
        assertEquals("Happy", foundMood.getName());
        verify(moodRepository, times(1)).findById(moodId);
    }

    @Test
    void testFindById_MoodNotFound() {
        
        Long moodId = 1L;
        when(moodRepository.findById(moodId)).thenReturn(Optional.empty());

        
        Mood foundMood = moodService.findById(moodId);

        
        assertNull(foundMood);
        verify(moodRepository, times(1)).findById(moodId);
    }

    @Test
    void testDeleteMood() {
        
        Long moodId = 1L;
        doNothing().when(moodRepository).deleteById(moodId);

        
        moodService.deleteMood(moodId);

        
        verify(moodRepository, times(1)).deleteById(moodId);
    }
}
