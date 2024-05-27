package com.omar.restapicrud.controller;

import com.omar.restapicrud.dto.PostDTO;
import com.omar.restapicrud.model.Post;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.PostRepository;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping()
    public Post createPost(@RequestBody PostDTO post) {
        return postService.createPost(post);
    }

    @GetMapping()
    public List<Post> getAllPosts(){
        return postService.listAllPosts();
    }

    @GetMapping("/{id}/remove")
    public void removePost(@PathVariable Long id) throws Exception {
        postService.removePost(id);
    }


    @GetMapping("/user/{id}")
    public List<Post> getAllPostsByUserId(@PathVariable Long id) {
        return postService.listAllPostsByUserId(id);
    }

    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
}
