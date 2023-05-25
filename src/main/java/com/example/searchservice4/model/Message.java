package com.example.searchservice4.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String userId;
    private String content;
    private List<String> hashtags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        extractHashtags();
    }

    public List<String> getHashtags() {return hashtags;}
    private void extractHashtags() {
        if (content != null && !content.isEmpty()) {
            hashtags = new ArrayList<>();
            String[] words = content.split("\\s+");
            for (String word : words) {
                if (word.startsWith("#")) {
                    hashtags.add(word.substring(1));
                }
            }
        }
    }

}
