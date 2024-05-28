package com.omar.restapicrud.service;

import com.omar.restapicrud.dto.UserDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.Post;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.CampusRepository;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.interfaces.iServiceUser;
import com.omar.restapicrud.service.validations.PostValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.omar.restapicrud.service.validations.UserValidations;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements iServiceUser<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidations userValidations;

    @Autowired
    private CampusRepository campusRepository;
    @Autowired
    private PostValidations postValidations;

    @Override
    public User createUser(UserDTO user) {
        if(userValidations.duplicateCarnetNumber(user.getCarnetNumber())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario ya existe");
        }

        Campus campus = campusRepository.findById(user.getCampusId()).get();
        String schoolMail = userValidations.getSchoolMail(user.getCarnetNumber());
        User newUser = new User(user.getName(),user.getLastName(),user.getCarnetNumber(),schoolMail,user.getPassword(),campus,user.getClabe());

        return userRepository.save(newUser);
    }

    @Override
    public List<User> createUsers(List<UserDTO> users) {
        List<User> savedUsers = new ArrayList<>();

        users.forEach(user -> {
            if(userValidations.duplicateCarnetNumber(user.getCarnetNumber())){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario ya existe");
            }

            Campus campus = campusRepository.findById(user.getCampusId()).get();
            String schoolMail = userValidations.getSchoolMail(user.getCarnetNumber());
            User newUser = new User(user.getName(),user.getLastName(),user.getCarnetNumber(),schoolMail,user.getPassword(),campus,user.getClabe());

            savedUsers.add(newUser);
        });


        return userRepository.saveAll(savedUsers);
    }

    @Override
    public User addPostToFavorites(Long userId, Long postId) {
        User user = userValidations.getUserById(userId);
        Post post = postValidations.getPostById(postId);

        List<Post> favoritesUserPosts = user.getUserFavoritePosts();

        if(!favoritesUserPosts.contains(post)){
            favoritesUserPosts.add(post);
            user.setUserFavoritePosts(favoritesUserPosts);

            return userRepository.save(user);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El post ya esta en la lista de favoritos");
    }

    @Override
    public User getUserById(Long id) {
        return userValidations.getUserById(id);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long id){
        User user = userValidations.getUserById(id);

        userRepository.delete(user);
    }
}
