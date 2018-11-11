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
    public Message createMessage(@RequestBody @Valid Message message) {
        return service.createMessage(message);
    }

    @RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
    public List<Message> getMessagesByChatId(@PathVariable(value = "chatId") int chatId) {
        return service.getMessagesByChatId(chatId);
    }

    @RequestMapping(value = "/sender/{chatId}/{senderId}", method = RequestMethod.GET)
    public List<Message> getMessagesBySenderIdAndChatId(@PathVariable(value = "senderId") int senderId, @PathVariable(value = "chatId") int chatId) {
        return service.getMessagesBySenderIdAndChatId(senderId, chatId);
    }

    @RequestMapping(value = "/receiver/{chatId}/{receiverId}", method = RequestMethod.GET)
    public List<Message> getMessagesByReceiverIdAndChatId(@PathVariable(value = "receiverId") int receiverId, @PathVariable(value = "chatId") int chatId) {
        return service.getMessagesByReceiverIdAndChatId(receiverId, chatId);
    }
}