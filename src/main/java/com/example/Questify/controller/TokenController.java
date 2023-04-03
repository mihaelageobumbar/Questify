package com.example.Questify.controller;

import com.example.Questify.model.Token;
import com.example.Questify.repository.TokenRepository;
import com.example.Questify.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @GetMapping("/{id}")
    public Token getTokenById(@PathVariable Long id) {
        return tokenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Token not found with id " + id));
    }

    @PostMapping
    public Token createToken(@RequestBody Token token) {
        return tokenRepository.save(token);
    }

    @PutMapping("/{id}")
    public Token updateToken(@PathVariable Long id, @RequestBody Token token) {
        Token existingToken = tokenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Token not found with id " + id));
        existingToken.setTokenValue(token.getTokenValue());
        return tokenRepository.save(existingToken);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToken(@PathVariable Long id) {
        Token existingToken = tokenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Token not found with id " + id));
        tokenRepository.delete(existingToken);
        return ResponseEntity.ok().build();
    }
}
