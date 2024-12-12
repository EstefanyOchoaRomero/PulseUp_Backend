package com.pulseup.pulseup_backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pulseup.pulseup_backend.dto.MoodRequestDTO;

public class MoodRequestDTOTest {

    @Test
    public void testConstructor() {
        MoodRequestDTO moodRequestDTO = new MoodRequestDTO();
        assertNotNull(moodRequestDTO);
    }

    @Test
    public void testConstructorConParametros() {
        MoodRequestDTO moodRequestDTO = new MoodRequestDTO("Ansioso", "Ejercicio físico");
        assertNotNull(moodRequestDTO);
        assertEquals("Ansioso", moodRequestDTO.getName());
        assertEquals("Ejercicio físico", moodRequestDTO.getDescription());
    }

    @Test
    public void testGetters() {
        MoodRequestDTO moodRequestDTO = new MoodRequestDTO();
        moodRequestDTO.setName("Ansioso");
        moodRequestDTO.setDescription("Ejercicio físico");
        assertEquals("Ansioso", moodRequestDTO.getName());
        assertEquals("Ejercicio físico", moodRequestDTO.getDescription());
    }

    @Test
    public void testSetters() {
        MoodRequestDTO moodRequestDTO = new MoodRequestDTO();
        moodRequestDTO.setName("Ansioso");
        moodRequestDTO.setDescription("Ejercicio físico");
        assertEquals("Ansioso", moodRequestDTO.getName());
        assertEquals("Ejercicio físico", moodRequestDTO.getDescription());
    }

    @Test
    public void testToString() {
        MoodRequestDTO moodRequestDTO = new MoodRequestDTO("Ansioso", "Ejercicio físico");
        String expected = "MoodRequestDTO{name='Ansioso', description='Ejercicio físico'}";
        assertEquals(expected, moodRequestDTO.toString());
    }



}
