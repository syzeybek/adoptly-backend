package com.adoptly.backend.controller;

import com.adoptly.backend.model.Animal;
import com.adoptly.backend.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "*")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // TEST İÇİN: Tarayıcıdan kontrol edebilmek adına GET ekliyoruz
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
    // 3. ID ile tek bir hayvan getir (GET)
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hayvan bulunamadı: " + id));
    }

    // 4. İlan Bilgilerini Güncelle (PUT)
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hayvan bulunamadı: " + id));
        
        animal.setName(animalDetails.getName());
        animal.setSpecies(animalDetails.getSpecies());
        animal.setAge(animalDetails.getAge());
        animal.setGender(animalDetails.getGender());
        animal.setStatus(animalDetails.getStatus());
        animal.setDescription(animalDetails.getDescription());
        animal.setImageUrl(animalDetails.getImageUrl());
        
        return animalRepository.save(animal);
    }

    // 5. İlanı Sil (DELETE)
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hayvan bulunamadı: " + id));
        
        animalRepository.delete(animal);
        return "İlan başarıyla silindi: " + id;
    }
    // 7. Filtreli Arama (GET)
    @GetMapping("/search")
    public List<Animal> searchAnimals(@RequestParam(required = false) String species) {
        if (species != null) {
            return animalRepository.findAll().stream()
                    .filter(a -> a.getSpecies().equalsIgnoreCase(species))
                    .toList();
        }
        return animalRepository.findAll();
    }
}