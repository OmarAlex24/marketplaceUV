package com.omar.restapicrud.service;

import com.omar.restapicrud.dto.UserDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.CampusRepository;
import com.omar.restapicrud.repository.UserRepository;
import com.omar.restapicrud.service.interfaces.iServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService implements iServiceUser<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CampusRepository campusRepository;

    @Override
    public User createUser(UserDTO user) {
        if(!userRepository.existsByCarnetNumberIgnoreCase(user.getCarnetNumber())){
            Campus campus = campusRepository.findById(user.getCampusId()).get();

            User newUser = new User(user.getName(),user.getLastName(),user.getCarnetNumber(),user.getSchoolMail(),user.getPassword(),campus,user.getClabe());

            return userRepository.save(newUser);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El usuario ya existe");

    }

    @Override
    public User getUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe el usuario a consultar");
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long id) throws Exception {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el usuario a eliminar");
        }
    }
}
