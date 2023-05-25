package com.example.searchservice4.repository;

import com.example.searchservice4.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @Query("{ 'content' : { $regex: ?0, $options: 'i' } }")
    List<Message> searchAllByContent(String text);

    @Query("{ 'hashtags' : { $regex: '^#?0$', $options: 'i' } }")
    List<Message> searchByHashtag(String hashtag);

}
