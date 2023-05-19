package com.example.searchservice4;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    // Add other necessary fields, such as sender, timestamp, hashtags, etc.

    // Getters and setters

}
