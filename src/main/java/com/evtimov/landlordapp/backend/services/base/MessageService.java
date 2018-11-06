package com.evtimov.landlordapp.backend.services.base;

import com.evtimov.landlordapp.backend.models.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Message message);

<<<<<<< HEAD
    void sendMessage(String receiverToken);

    /*List<Message> getAllDeliveredMessagesByTenantId(int tenantId);

    List<Message> getAllUndeliveredMessagesByTenantId(int tenantId);

    List<Message> getAllDeliveredMessagesByLandlordId(int landlordId);

    List<Message> getAllUndeliveredMessagesByLandlordId(int landlordId);*/
=======
    List<Message> getMessagesBySenderIdAndChatId(int senderId, int chatId);

    List<Message> getMessagesByReceiverIdAndChatId(int receiverId, int chatId);
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4

}
