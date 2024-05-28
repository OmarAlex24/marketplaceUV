package com.omar.restapicrud.service.validations;

import com.omar.restapicrud.model.Category;
import com.omar.restapicrud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryValidations {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe una categoria con ese id"));
    }
}
