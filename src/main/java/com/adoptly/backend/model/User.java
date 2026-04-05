package com.adoptly.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    
    @Column(unique = true) // Aynı e-posta ile iki kayıt yapılamaz
    private String email;
    
    private String password;
    
    private String role; // "USER" veya "SHELTER" (Barınak)
}