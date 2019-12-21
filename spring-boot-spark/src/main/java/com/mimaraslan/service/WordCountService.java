package com.mimaraslan.service;

import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCountService {

    @Autowired
    JavaSparkContext sc;

    public Map<String, Long> getCount(List<String> wordList) {
        JavaRDD<String> words = sc.parallelize(wordList);
        Map<String, Long> wordCounts = words.countByValue();
        return wordCounts;
    }

}