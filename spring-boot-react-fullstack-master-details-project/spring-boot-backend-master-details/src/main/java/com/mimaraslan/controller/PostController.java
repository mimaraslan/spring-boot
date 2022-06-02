package com.mimaraslan.controller;

import com.mimaraslan.model.Post;
import com.mimaraslan.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // http://localhost:8082/api/posts
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    // http://localhost:8082/api/posts/1
    @GetMapping ("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePost(postId);
    }

    // http://localhost:8082/api/posts
    @PostMapping
    public Post createOnePost(@RequestBody Post newPost){
        return postService.createOnePost(newPost);
    }

}
