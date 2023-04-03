package com.example.Questify.service;

import com.example.Questify.model.Badge;
import com.example.Questify.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> findAllBadges() {
        return badgeRepository.findAll();
    }

    public Badge findBadgeById(Long id) {
        return badgeRepository.findById(id).orElse(null);
    }

    public Badge saveBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    public void deleteBadgeById(Long id) {
        badgeRepository.deleteById(id);
    }
}
