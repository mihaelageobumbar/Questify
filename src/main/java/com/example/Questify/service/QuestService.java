package com.example.Questify.service;

import com.example.Questify.model.Quest;
import com.example.Questify.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {
    @Autowired
    private QuestRepository questRepository;

    public List<Quest> findAllQuests() {
        return questRepository.findAll();
    }

    public Quest findQuestsById(Long id) {
        return questRepository.findById(id).orElse(null);
    }

    public Quest saveQuest(Quest quest) {
        return questRepository.save(quest);
    }

    public void deleteQuestById(Long id) {
        questRepository.deleteById(id);
    }
}
