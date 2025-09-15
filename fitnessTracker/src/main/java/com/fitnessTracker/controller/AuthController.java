package com.fitnessTracker.controller;

import com.fitnessTracker.dto.*;
import com.fitnessTracker.model.User;
import com.fitnessTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.fitnessTracker.security.jwt.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils; // <-- 1. INJECT your JwtUtils bean

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userService.usernameExists(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken!");
        }
        if (userService.emailExists(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use!");
        }

        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // --- THIS IS THE FIX ---
        // 2. GET the username from the authenticated object.
        String username = authentication.getName();

        // 3. GENERATE the real JWT token using your JwtUtils class.
        String jwtToken = jwtUtils.generateJwtToken(username);

        // 4. RETURN the real token in the response.
        return ResponseEntity.ok(new JwtResponse(jwtToken));

//        // Normally you generate JWT here
//        String jwtToken = "FAKE-JWT-TOKEN"; // placeholder for now
//        return ResponseEntity.ok(new JwtResponse(jwtToken));
    }
}

