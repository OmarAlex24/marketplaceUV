package com.omar.restapicrud.controller;

import com.omar.restapicrud.dto.UserDTO;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import com.omar.restapicrud.model.User; // Import the correct User class

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping()
  public User createUser(@RequestBody UserDTO user) {
    return userService.createUser(user);
  }

  @PostMapping("/batch")
  public List<User> createUsers(@RequestBody List<UserDTO> users){
    return userService.createUsers(users);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.listAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/{id}/remove")
  public void removeUser(@PathVariable Long id) throws Exception {
      userService.removeUser(id);
  }

  @PostMapping("/{userId}/add/{postId}")
  public User addPostToFavorites(@PathVariable Long userId, @PathVariable Long postId){
    return userService.addPostToFavorites(userId, postId);
  }
}
