package com.ecommerce.app.controller;

import com.ecommerce.app.modal.Category;
import com.ecommerce.app.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("api/public/categories")
    public List<Category> getAllCategory()
    {
        return categoryServiceImpl.getAllCategories();
    }

    @PostMapping("api/public/categories")
    public String createCategory(@RequestBody Category category)
    {
        categoryServiceImpl.createCategory(category);
        return "Category successfully created";
    }

    @DeleteMapping("api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId)
    {
        return categoryServiceImpl.deleteCategory(categoryId);
    }
}
