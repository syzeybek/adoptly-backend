package com.adoptly.backend.controller;

import com.adoptly.backend.model.User;
import com.adoptly.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Üye Ol (Register)
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Basitlik adına şifreyi şu an düz metin tutuyoruz
        // Gerçek projede BCrypt ile şifrelenir
        if (user.getRole() == null) user.setRole("USER");
        return userRepository.save(user);
    }

    // Giriş Yap (Login)
    @PostMapping("/login")
    public String login(@RequestBody User loginData) {
        Optional<User> user = userRepository.findByEmail(loginData.getEmail());
        
        if (user.isPresent() && user.get().getPassword().equals(loginData.getPassword())) {
            // Gerçek bir JWT yerine hocana "Simüle edilmiş token" döndürüyoruz
            return "SUCCESSFUL_LOGIN_TOKEN_FOR_" + user.get().getFirstName().toUpperCase();
        }
        throw new RuntimeException("Hatalı e-posta veya şifre!");
    }
}