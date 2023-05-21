package com.example.searchservice4.controller;

import com.example.searchservice4.service.SearchService;
import com.example.searchservice4.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/hashtag/{hashtag}")
    public List<Message> searchByHashtag(@PathVariable("hashtag") String hashtagToSearch) {
        return searchService.searchByHashtag(hashtagToSearch);
    }

    @GetMapping("/text/{text}")
    public List<Message> searchByText(@PathVariable("text") String textToSearch) {
        return searchService.searchByText(textToSearch);
    }
}
