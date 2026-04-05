package com.adoptly.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Data
public class AdoptionApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bir kullanıcı birden fazla başvuru yapabilir (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Bir hayvan için birden fazla kişi başvurabilir (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    private LocalDateTime applicationDate = LocalDateTime.now();
}