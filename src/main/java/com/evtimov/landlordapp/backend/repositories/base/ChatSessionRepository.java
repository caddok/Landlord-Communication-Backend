package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.ChatSession;

import java.util.List;

public interface ChatSessionRepository {

    List<ChatSession> getAllByUserId(int userId);

    ChatSession createSession(ChatSession chat);

    ChatSession deleteChat(int chatId);
}
