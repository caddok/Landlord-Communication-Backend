package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.models.Message;
import com.evtimov.landlordapp.backend.services.base.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)                      // NOT WORKING POST method
    public Message createMessage(@RequestBody Message message){
        service.createMessage(message);
        return message;
    }

    @RequestMapping(value = "/tenantdelivered/{tenantIdDelivered}", method = RequestMethod.GET)
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
    }
}
