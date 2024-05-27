package com.omar.restapicrud.service;

import com.omar.restapicrud.controller.UserController;
import com.omar.restapicrud.dto.PostDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.Category;
import com.omar.restapicrud.repository.CampusRepository;
import com.omar.restapicrud.repository.PostRepository;
import com.omar.restapicrud.model.Post;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.CategoryRepository;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.interfaces.iServicePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class PostService implements iServicePost<Post> {
//
//    private String title;
//    private String description;
//    private Date publicationDate;
//    private Long articlePrice;
//    private Long categoryId;
//    private Long ownerId;
//    private Long ownerCampusId;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @Override
    public Post createPost(PostDTO post) {
        User ownerUser = userController.getUserById(post.getOwnerId());

        if(ownerUser != null){
            Category category = categoryRepository.findById(post.getCategoryId()).get();
            Campus campus = ownerUser.getCampus();

            Post nuevoPost = new Post(post.getTitle(), post.getDescription(), new Date(), post.getArticlePrice(),
                     category.getProductCategoryId(), campus, ownerUser);
            return postRepository.save(nuevoPost);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe un usuario con ese id"
        );
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public List<Post> listAllPosts() {
        return List.of();
    }

    @Override
    public List<Post> listAllPostsByUserId(Long id) {
        User user = userController.getUserById(id);

        return user.getUserPosts();
    }

    @Override
    public void removePost(Long id) throws Exception {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el post a eliminar");
        }
    }
}
