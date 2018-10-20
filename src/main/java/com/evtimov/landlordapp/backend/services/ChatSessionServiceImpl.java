package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import com.evtimov.landlordapp.backend.services.base.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ChatSessionServiceImpl implements ChatSessionService {

    private final ChatSessionRepository repository;

    @Autowired
    public ChatSessionServiceImpl(ChatSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ChatSession> getAllByUserId(int userId) {
        return repository.getAllByUserId(userId);
    }

    @Override
    public ChatSession createSession(ChatSession chat){
        repository.createSession(chat);
        return chat;
    }
}
