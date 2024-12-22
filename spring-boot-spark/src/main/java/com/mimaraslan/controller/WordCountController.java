package com.mimaraslan.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mimaraslan.service.WordCountService;

// http://localhost:8085

@RestController
@RequestMapping
public class WordCountController {

    @Autowired
    WordCountService service;

    // http://localhost:8085/wordcount

    @PostMapping("/wordcount")
    public Map<String, Long> count(@RequestParam(required = false) String words) {
        List<String> wordList = Arrays.asList(words.split("\\|"));
        return service.getCount(wordList);
    }

}