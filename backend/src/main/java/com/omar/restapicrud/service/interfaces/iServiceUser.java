package com.omar.restapicrud.service.interfaces;

import com.omar.restapicrud.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iServiceUser <T>{
    public T createUser(@RequestBody UserDTO t);
    public T getUserById(@PathVariable Long id);
    public List<T> listAllUsers ();
    public void removeUser(@PathVariable Long id) throws Exception;

}
