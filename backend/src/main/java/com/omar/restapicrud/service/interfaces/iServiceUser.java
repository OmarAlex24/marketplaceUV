package com.omar.restapicrud.service.interfaces;

import com.omar.restapicrud.dto.UserDTO;
import com.omar.restapicrud.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServiceUser <T>{
    public T createUser(@RequestBody UserDTO t);
    public List<T> createUsers(@RequestBody List<UserDTO> t);
    public User addPostToFavorites(@RequestBody Long userId, Long postId);
    public T getUserById(@PathVariable Long id);
    public List<T> listAllUsers ();
    public void removeUser(@PathVariable Long id) throws Exception;

}
