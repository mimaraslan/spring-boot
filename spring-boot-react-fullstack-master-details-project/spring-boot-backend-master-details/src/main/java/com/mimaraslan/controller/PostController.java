package com.mimaraslan.controller;

import com.mimaraslan.model.Post;
import com.mimaraslan.model.request.PostCreateRequest;
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
    // http://localhost:8082/api/posts?userId=1
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    // http://localhost:8082/api/posts/1
    @GetMapping ("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    // http://localhost:8082/api/posts/v1
    @PostMapping("/v1")
    public Post createOnePost1(@RequestBody Post newPost){
        return postService.createOnePost1(newPost);
    }

    // http://localhost:8082/api/posts
    @PostMapping
    public Post createOnePost2(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost2(newPostRequest);
    }


    // http://localhost:8082/api/posts/1
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody Post updatePost){
        return postService.updateOnePostById(postId, updatePost);
    }

    // http://localhost:8082/api/posts/1
    @DeleteMapping("/{postId}")
    public String deleteOnePost(@PathVariable Long postId){
        return postService.deleteOnePostById(postId);
    }

}
