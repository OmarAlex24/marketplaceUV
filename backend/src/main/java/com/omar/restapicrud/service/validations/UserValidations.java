package com.omar.restapicrud.service.validations;

import com.omar.restapicrud.dto.UserDTO;
import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.User;
import com.omar.restapicrud.repository.CampusRepository;
import com.omar.restapicrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserValidations {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CampusRepository campusRepository;

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un usuario con ese id"));
    }

    public boolean duplicateCarnetNumber(String carnetNumber) {
        return userRepository.existsByCarnetNumberIgnoreCase(carnetNumber);
    }

    public String getSchoolMail(String carnetNumber){
        return carnetNumber + "@estudiantes.uv.mx";
    }
}
