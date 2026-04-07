package com.adoptly.backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pets")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

   
    @Column(name = "breed", nullable = false)
    private String species;

   
    private String age;

   
    private String gender;

   
    @Column(name = "location")
    private String city;

   
    private String status = "AVAILABLE";

   
    @Column(name = "story")
    private String description;

    
    @Column(name = "\"imageUrl\"")
    private String imageUrl;

   
    @Column(name = "\"ownerEmail\"")
    private String ownerEmail;

    @Column(name = "user_id")
    private UUID userId;

    public Animal() {
    }

    // --- GETTER VE SETTER METOTLARI ---
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
}
