package com.example.Questify.controller;

import com.example.Questify.model.Quest;
import com.example.Questify.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @Autowired
    private QuestRepository questRepository;

    @GetMapping
    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    @GetMapping("/{id}")
    public Quest getQuestById(@PathVariable Long id) {
        return questRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
    }

    @PostMapping
    public Quest createQuest(@RequestBody Quest quest) {
        return questRepository.save(quest);
    }

    @PutMapping("/{id}")
    public Quest updateQuest(@PathVariable Long id, @RequestBody Quest quest) {
        Quest existingQuest = questRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
        existingQuest.setName(quest.getName());
        existingQuest.setDescription(quest.getDescription());
        return questRepository.save(existingQuest);
    }

    @DeleteMapping("/{id}")
    public void deleteQuest(@PathVariable Long id) {
        Quest quest = questRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
        questRepository.delete(quest);
    }

    @PostMapping("/{id}/complete")
    public void completeQuest(@PathVariable Long id) {
        Quest quest = questRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quest not found"));
    }
}

