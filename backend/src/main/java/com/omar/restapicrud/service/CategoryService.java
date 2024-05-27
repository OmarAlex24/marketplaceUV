package com.omar.restapicrud.service;

import com.omar.restapicrud.model.Category;
import com.omar.restapicrud.repository.CategoryRepository;
import com.omar.restapicrud.service.interfaces.iServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService implements iServiceCategory<Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        if (!categoryRepository.existsByCategoryNameIgnoreCase(category.getCategoryName())) {
            return categoryRepository.save(category);
        }
        throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Ya existe una categoria con ese nombre");
    }

    @Override
    public Category getCategoryById(Long id) {
        if(categoryRepository.existsById(id)){
            return categoryRepository.findById(id).get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe la categoria a consultar");
    }

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void removeCategory(Long id) throws Exception {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe la categoria a eliminar");
        }
    }
}
