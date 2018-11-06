package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
<<<<<<< HEAD
    public Message getMessage(@RequestBody Message message) {
=======
    public Message createMessage(@RequestBody @Valid Message message){
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
        service.createMessage(message);
        return message;
    }

<<<<<<< HEAD
    @RequestMapping(method = RequestMethod.GET)                      // NOT WORKING POST method
    public Message sendMessage(@RequestBody Message message){
        service.sendMessage(message.getReceiverToken());
        return message;
    }

    /*@RequestMapping(value = "/tenantdelivered/{tenantIdDelivered}", method = RequestMethod.GET)
    public List<Message> getAllDeliveredMessagesByTenantId(@PathVariable(value = "tenantIdDelivered") int tenantId){
        return service.getAllDeliveredMessagesByTenantId(tenantId);
    }

    @RequestMapping(value = "/tenantundelivered/{tenantIdUndelivered}", method = RequestMethod.GET)
    public List<Message> getAllUndeliveredMessagesByTenantId(@PathVariable(value = "tenantIdUndelivered") int tenantId){
        return service.getAllUndeliveredMessagesByTenantId(tenantId);
    }

    @RequestMapping(value = "/landlorddelivered/{landlordIdDelivered}", method = RequestMethod.GET)
    public List<Message> getAllDeliveredMessagesByLandlordId(@PathVariable(value = "landlordIdDelivered") int landlordId){
        return service.getAllDeliveredMessagesByLandlordId(landlordId);
    }

    @RequestMapping(value = "/landlordundelivered/{landlordIdUndelivered}", method = RequestMethod.GET)
    public List<Message> getAllUndeliveredMessagesByLandlordId(@PathVariable(value = "landlordIdUndelivered") int landlordId){
        return service.getAllUndeliveredMessagesByLandlordId(landlordId);
    }*/
=======
    @RequestMapping(value = "/sender/{chatId}/{senderId}", method = RequestMethod.GET)
    public List<Message> getMessagesBySenderIdAndChatId(@PathVariable(value = "senderId") int senderId, @PathVariable(value = "chatId")int chatId){
        return service.getMessagesBySenderIdAndChatId(senderId, chatId);
    }

    @RequestMapping(value = "/receiver/{chatId}/{receiverId}", method = RequestMethod.GET)
    public List<Message> getMessagesByReceiverIdAndChatId(@PathVariable(value = "receiverId") int receiverId, @PathVariable(value = "chatId")int chatId){
        return service.getMessagesByReceiverIdAndChatId(receiverId, chatId);
    }
>>>>>>> 5b466dffa9d1220212ba3c19f1bf0f0a333530e4
}
