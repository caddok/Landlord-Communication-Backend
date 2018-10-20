package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Message message);

    List<Message> getAllDeliveredMessagesByTenantId(int tenantId);

    List<Message> getAllUndeliveredMessagesByTenantId(int tenantId);

    List<Message> getAllDeliveredMessagesByLandlordId(int landlordId);

    List<Message> getAllUndeliveredMessagesByLandlordId(int landlordId);

}
