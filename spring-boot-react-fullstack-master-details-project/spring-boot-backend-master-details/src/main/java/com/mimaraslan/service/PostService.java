package com.mimaraslan.service;

import com.mimaraslan.model.Post;
import com.mimaraslan.model.User;
import com.mimaraslan.model.request.PostCreateRequest;
import com.mimaraslan.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
          return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost1(Post newPost) {
        return postRepository.save(newPost);
    }

    public Post createOnePost2(PostCreateRequest newPostRequest) {
     User userObj =  userService.getOneUser(newPostRequest.getUserId());
        if (userObj == null)
            return null;

        Post postObj = new Post();
        postObj.setId(newPostRequest.getId());
        postObj.setTitle(newPostRequest.getTitle());
        postObj.setText(newPostRequest.getText());
        postObj.setUser(userObj);
        return postRepository.save(postObj);
    }

    public Post updateOnePostById(Long postId,  Post updatePost) {
        Optional<Post> postObj= postRepository.findById(postId);
        if (postObj.isPresent()) {
            Post toUpdate = postObj.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        } else {
            return null;
        }    }

    public String deleteOnePostById(Long postId) {
        if (postRepository.findById(postId).isPresent()) {
            postRepository.deleteById(postId);
            return "Deleted one user";
        } else {
            return null;
        }    }
}
