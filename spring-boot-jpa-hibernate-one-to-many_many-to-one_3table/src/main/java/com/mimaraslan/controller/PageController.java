package com.mimaraslan.controller;

import com.mimaraslan.model.Page;
import com.mimaraslan.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PageController {

    @Autowired
    PageRepository pageRepository;

    // http://localhost:8082/api/v1/pages
    @GetMapping("/pages")
    public List<Page> getPagesAll() {
        return pageRepository.findAll();
    }

    // http://localhost:8082/api/v1/pages/1
    @GetMapping("/pages/{id}")
    public ResponseEntity<Optional<Page>> getPageFindById(@PathVariable("id") Long id) {
        Optional<Page> page = pageRepository.findById(id);
        return ResponseEntity.ok().body(page);
    }
}