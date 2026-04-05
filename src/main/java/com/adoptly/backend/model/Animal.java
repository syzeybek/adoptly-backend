package com.adoptly.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String species; // "Cat" veya "Dog"
    
    private Integer age;
    
    private String gender; // "Male" veya "Female"
    
    private String status; // "AVAILABLE" veya "ADOPTED"
    
    private String imageUrl;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * CascadeType.ALL: Bu hayvan silindiğinde, ona bağlı tüm başvurular da silinir.
     * orphanRemoval = true: Liste içerisinden bir başvuru çıkarılırsa veritabanından da silinmesini sağlar.
     * mappedBy = "animal": Bu ilişkinin AdoptionApplication sınıfındaki 'animal' alanı üzerinden kurulduğunu belirtir.
     */
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdoptionApplication> applications;
}