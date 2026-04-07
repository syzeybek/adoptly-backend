package com.adoptly.backend.repository;

import com.adoptly.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Spring Data JPA temel veritabanı işlemlerini arka planda halleder.
}