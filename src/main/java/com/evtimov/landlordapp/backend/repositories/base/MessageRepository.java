package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Message;

import java.util.Date;
import java.util.List;

public interface MessageRepository {

    Message createMessage(Message message);

    List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId, Date date);

    List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId, Date date);

    List<Message> getMessagesByChatId(int chatId);
}
