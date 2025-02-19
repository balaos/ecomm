package com.sample.ecomm.controller;

import com.sample.ecomm.message.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private RabbitMQSender sender;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        sender.sendMessage(message);
        return "Message sent: " + message;
    }
}
