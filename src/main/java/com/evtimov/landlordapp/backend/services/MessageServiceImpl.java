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

        repository.createMessage(message);

        return message;
    }

    @Override
    public List<Message> getAllDeliveredMessagesByTenantId(int tenantId) {
        return repository.getAllDeliveredMessagesByTenantId(tenantId);
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByTenantId(int tenantId) {
        return repository.getAllUndeliveredMessagesByTenantId(tenantId);
    }

    @Override
    public List<Message> getAllDeliveredMessagesByLandlordId(int landlordId) {
        return repository.getAllDeliveredMessagesByLandlordId(landlordId);
    }

    @Override
    public List<Message> getAllUndeliveredMessagesByLandlordId(int landlordId) {
        return repository.getAllUndeliveredMessagesByLandlordId(landlordId);
    }
}
