package com.ecommerce.app.service;

import com.ecommerce.app.modal.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories = new ArrayList<>();
    private Long categoryId = 1L;
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(categoryId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categories.stream().
                            filter(c -> c.getCategoryId().equals(categoryId)).
                            findFirst().orElse(null);

        if(category == null)
            return "Category Not Found";

        categories.remove(category);
        return "Category with category id "+ categoryId +" successfully deleted";
    }
}
