package com.omar.restapicrud.service;


import com.omar.restapicrud.dto.PostDTO;
import com.omar.restapicrud.model.Category;
import com.omar.restapicrud.repository.PostRepository;
import com.omar.restapicrud.model.Post;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.CategoryRepository;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.interfaces.iServicePost;
import com.omar.restapicrud.service.validations.CategoryValidations;
import com.omar.restapicrud.service.validations.PostValidations;
import com.omar.restapicrud.service.validations.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements iServicePost<Post> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryValidations categoryValidations;

    @Autowired
    private UserValidations userValidations;

    @Autowired
    private PostValidations postValidations;

    @Override
    public Post createPost(PostDTO post) {
        User ownerUser = userValidations.getUserById(post.getOwnerId());

        Category category = categoryValidations.getCategoryById(post.getCategoryId());

        Post nuevoPost = new Post(post.getTitle(), post.getDescription(), new Date(), post.getArticlePrice(), post.getQuantity(),
                 category.getProductCategoryId(), ownerUser);

        return postRepository.save(nuevoPost);

    }

    @Override
    public List<Post> createPosts(List<PostDTO> posts) {
        List<Post> savedPosts = new ArrayList<>();

        posts.forEach(post -> {
            User ownerUser = userValidations.getUserById(post.getOwnerId());

            Category category = categoryValidations.getCategoryById(post.getCategoryId());

            Post nuevoPost = new Post(post.getTitle(), post.getDescription(), new Date(), post.getArticlePrice(), post.getQuantity(),
                    category.getProductCategoryId(), ownerUser);

            savedPosts.add(nuevoPost);
        });

        return postRepository.saveAll(savedPosts);
    }

    @Override
    public void togglePostVisibility(Long id) {
        Post post = postValidations.getPostById(id);

        post.setIsActive(!post.getIsActive());
    }

    @Override
    public Post getPostById(Long id) {
        return postValidations.getPostById(id);
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> listAllPostsByUserId(Long id) {
        User user = userValidations.getUserById(id);

        return user.getUserPosts();
    }

    @Override
    public void removePost(Long id) {
        Post post = postValidations.getPostById(id);

        postRepository.delete(post);
    }
}
