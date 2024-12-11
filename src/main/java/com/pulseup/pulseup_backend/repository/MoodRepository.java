package com.pulseup.pulseup_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pulseup.pulseup_backend.models.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> findByName(String name);
}
