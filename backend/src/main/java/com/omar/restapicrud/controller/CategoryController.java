package com.omar.restapicrud.controller;

import com.omar.restapicrud.model.Campus;
import com.omar.restapicrud.model.Category;
import com.omar.restapicrud.service.CampusService;
import com.omar.restapicrud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.listAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}/remove")
    public void removeCategory(@PathVariable Long id) throws Exception {
        categoryService.removeCategory(id);
    }
}
