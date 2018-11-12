package com.evtimov.landlordapp.backend.services;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.repositories.base.MessageRepository;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import com.evtimov.landlordapp.backend.utils.DateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;
    private final DateProvider dateProvider;

    @Autowired
    public MessageServiceImpl(MessageRepository repository, DateProvider dateProvider) {
        this.repository = repository;
        this.dateProvider = dateProvider;
    }


    @Override
    public Message createMessage(Message message) {
        return repository.createMessage(message);
    }

    @Override
    public List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId) {
        Date date = dateProvider.getDateBeforeThreeMonths();
        return repository.getMessagesBySenderIdAndChatId(senderId, chatId, date);
    }

    @Override
    public List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId) {
        Date date = dateProvider.getDateBeforeThreeMonths();
        return repository.getMessagesByReceiverIdAndChatId(receiverId, chatId, date);
    }

    @Override
    public List<Message> getMessagesByChatId(int chatId) {
        return repository.getMessagesByChatId(chatId);
    }
}
