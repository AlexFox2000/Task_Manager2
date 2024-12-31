package com.task.mc_user.service;
import com.task.mc_user.entity.Role;
import com.task.mc_user.entity.User;
import com.task.mc_user.repositroy.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        validatePassword(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        return userRepository.save(user);
    }

    private void validatePassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
        if (!password.matches(".*[@#$%^&+=].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character (@#$%^&+=).");
        }
    }



    public User getUserById (Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + " not found."));
    }

    public List <User> getAllUsers (){
        return userRepository.findAll();
    }

    public User updateUser (User updatedUser, Long id){
        User exist = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + " not found."));

        exist.setRole(updatedUser.getRole());

        return userRepository.save(exist);
    }

    public void deleteUser (Long id){
        User exist = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + " not found."));
        userRepository.delete(exist);

    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Error, check username and password.");
        }
        String token = generateToken(user);
        return token;
    }

    private String generateToken(User user) {
        long expirationTime = 3600000;
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, "your_secret_key")
                .compact();
    }




}
