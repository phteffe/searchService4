package com.example.searchservice4;

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
