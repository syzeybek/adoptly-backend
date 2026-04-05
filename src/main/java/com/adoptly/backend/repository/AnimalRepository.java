package com.adoptly.backend.repository;

import com.adoptly.backend.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // JpaRepository sayesinde ekleme, silme, listeleme metodları hazır gelir!
}