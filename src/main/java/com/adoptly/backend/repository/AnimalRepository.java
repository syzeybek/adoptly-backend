package com.adoptly.backend.repository;

import com.adoptly.backend.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // Spring Data JPA arka planda kaydetme, silme, bulma gibi tüm işlemleri bizim için yazar.
    // Şimdilik içinin boş olması tamamen normaldir.
}