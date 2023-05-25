package com.example.searchservice4.controller;


import com.example.searchservice4.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class PublishMessageController {

    private RabbitTemplate rabbitTemplate;

    private String exchange ="messagesExchange";

    private String routingJsonKey = "messagesKey";

    public PublishMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publish")
    public Message publishMessage(@RequestBody Message messageToPublish) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,messageToPublish);
        return messageToPublish;
    }
}
