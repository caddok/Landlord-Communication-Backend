package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Message message);

    List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId);

    List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId);

    List<Message> getMessagesByChatId(int chatId);

}
