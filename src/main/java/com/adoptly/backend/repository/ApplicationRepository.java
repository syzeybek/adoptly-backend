package com.adoptly.backend.repository;

import com.adoptly.backend.model.AdoptionApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<AdoptionApplication, Long> {
    // Belirli bir kullanıcının başvurularını getirmek için:
    List<AdoptionApplication> findByUserId(Long userId);
}