package com.adoptly.backend.controller;

import com.adoptly.backend.model.AdoptionApplication;
import com.adoptly.backend.model.Animal;
import com.adoptly.backend.model.User;
import com.adoptly.backend.repository.ApplicationRepository;
import com.adoptly.backend.repository.AnimalRepository;
import com.adoptly.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;

    public ApplicationController(ApplicationRepository applicationRepository, 
                                 UserRepository userRepository, 
                                 AnimalRepository animalRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.animalRepository = animalRepository;
    }

    // Başvuru Yap (POST)
    @PostMapping
    public AdoptionApplication submitApplication(@RequestParam Long userId, 
                                                 @RequestParam Long animalId, 
                                                 @RequestBody String message) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("Hayvan bulunamadı"));

        AdoptionApplication application = new AdoptionApplication();
        application.setUser(user);
        application.setAnimal(animal);
        application.setMessage(message);

        return applicationRepository.save(application);
    }

    // Kullanıcının Başvurularını Listele (GET)
    @GetMapping("/my")
    public List<AdoptionApplication> getMyApplications(@RequestParam Long userId) {
        return applicationRepository.findByUserId(userId);
    }
}