package com.example.Questify.controller;

import com.example.Questify.model.Badge;
import com.example.Questify.model.Quest;
import com.example.Questify.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeRepository badgeRepository;

    @GetMapping
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Badge getBadgeById(@PathVariable Long id) {
        return badgeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
    }

    @PostMapping
    public Badge createBadge(@RequestBody Badge badge) {
        return badgeRepository.save(badge);
    }

    @PutMapping("/{id}")
    public Badge updateQuest(@PathVariable Long id, @RequestBody Quest quest) {
        Badge existingBadge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
        existingBadge.setBadgeName(existingBadge.getBadgeName());
        return badgeRepository.save(existingBadge);
    }

    @DeleteMapping("/{id}")
    public void deleteBadge(@PathVariable Long id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
        badgeRepository.delete(badge);
    }
}


