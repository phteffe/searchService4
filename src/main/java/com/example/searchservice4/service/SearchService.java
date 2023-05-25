package com.example.searchservice4.service;

import com.example.searchservice4.model.Message;
import com.example.searchservice4.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//TODO
// Schema of the Search Service could be like this:
// 1. Controller with two methods searchByHashtag(string hashtagToSearch) and searchByText(string textToSearch)
// 2. Entity for the messages
// 3. Repository that connects to MongoDB with two methods to retrieve messages and another to save messages
// 4. A service that consumes messages from RabbitMQ and stores them in MongoDB

@Service
public class SearchService {
    private MessageRepository messageRepository;

    public SearchService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public List<Message> searchByHashtag(String hashtagToSearch) {
        return messageRepository.searchByHashtag(hashtagToSearch);
    }

    public List<Message> searchByText(String textToSearch) {
        return messageRepository.searchAllByContent(textToSearch);

    }





}
