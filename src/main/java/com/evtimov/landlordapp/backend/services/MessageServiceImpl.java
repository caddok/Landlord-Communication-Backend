package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }


    @Override
    public Message createMessage(Message message) {
        return repository.createMessage(message);
    }

    @Override
    public List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId) {
        return repository.getMessagesBySenderIdAndChatId(senderId,chatId);
    }

    @Override
    public List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId) {
        return repository.getMessagesByReceiverIdAndChatId(receiverId,chatId);
    }

    @Override
    public List<Message> getMessagesByChatId(int chatId) {
        return repository.getMessagesByChatId(chatId);
    }
}