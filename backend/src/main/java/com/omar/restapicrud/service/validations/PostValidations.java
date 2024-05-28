package com.omar.restapicrud.service.validations;

import com.omar.restapicrud.model.Post;
import com.omar.restapicrud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PostValidations {

    @Autowired
    PostRepository postRepository;

    public Post getPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un post con ese id"));
    }
}
