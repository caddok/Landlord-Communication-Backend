package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.ChatSession;

import java.util.List;

public interface ChatSessionService {

    List<ChatSession> getAllByTenantId(int tenantId);

    List<ChatSession> getAllByLandlordId(int landlordId);

    ChatSession createChat(ChatSession chat);

    void deleteChat(int chatId);

}
