package com.example.searchservice4.repository;

import com.example.searchservice4.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    // Method to retrieve messages
    List<Message> findByContentContaining(String text);

    // Method to save messages



}
