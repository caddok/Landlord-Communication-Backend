package com.evtimov.landlordapp.backend.controllers;


import com.evtimov.landlordapp.backend.services.base.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }
}
