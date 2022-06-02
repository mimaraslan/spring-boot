package com.mimaraslan.service;

import com.mimaraslan.model.Post;
import com.mimaraslan.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
          return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(Post newPost) {
        return postRepository.save(newPost);
    }
}
