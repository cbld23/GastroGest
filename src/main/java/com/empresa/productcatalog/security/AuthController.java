package com.empresa.productcatalog.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${app.user.username}")
    private String username;

    @Value("${app.user.password}")
    private String password;

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        if (authRequest.getUsername().equals(username) && authRequest.getPassword().equals(password)) {
            String token = jwtUtil.generateToken(authRequest.getUsername());
            AuthResponse authResponse = new AuthResponse(token); // Crea una respuesta con el token
            return ResponseEntity.ok(authResponse);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}

