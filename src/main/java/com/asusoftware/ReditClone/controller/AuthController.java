package com.asusoftware.ReditClone.controller;

import com.asusoftware.ReditClone.model.dto.LoginRequest;
import com.asusoftware.ReditClone.model.dto.RegisterRequest;
import com.asusoftware.ReditClone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("User registration successful!", HttpStatus.OK);
    }

    @GetMapping(path = "/accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable(name = "token") String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated successfully", HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public void login(@RequestBody LoginRequest loginRequest) {
        authService.login(loginRequest);
    }
}
