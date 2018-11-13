package com.evtimov.landlordapp.backend.services;

import com.evtimov.landlordapp.backend.models.ChatSession;
import com.evtimov.landlordapp.backend.repositories.base.ChatSessionRepository;
import com.evtimov.landlordapp.backend.services.base.ChatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatSessionServiceImpl implements ChatSessionService {

    private final ChatSessionRepository repository;

    @Autowired
    public ChatSessionServiceImpl(ChatSessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ChatSession> getAllByTenantId(int tenantId) {
        return repository.getAllByTenantId(tenantId);
    }

    @Override
    public List<ChatSession> checkIfChatSessionExistsByTenantIdAndLandlordId(int tenantId, int landlordId) {
        return repository.checkIfChatSessionExistsByTenantIdAndLandlordId(tenantId, landlordId);
    }

    @Override
    public List<ChatSession> getAllByLandlordId(int landlordId) {
        return repository.getAllByLandlordId(landlordId);
    }

    @Override
    public ChatSession createChat(ChatSession chat) {
        return repository.createSession(chat);
    }
}