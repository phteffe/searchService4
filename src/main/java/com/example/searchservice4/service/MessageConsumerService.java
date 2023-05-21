package com.example.searchservice4.service;

import com.example.searchservice4.repository.MessageRepository;
import com.example.searchservice4.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    private final MessageRepository messageRepository;

    public MessageConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RabbitListener(queues = "messageQueue")
    public void receiveMessage(Message message) {
        messageRepository.save(message);
    }
}
