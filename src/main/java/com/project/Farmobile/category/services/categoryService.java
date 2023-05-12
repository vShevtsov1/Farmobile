package com.project.Farmobile.category.services;

import com.project.Farmobile.category.data.category;
import org.springframework.stereotype.Service;
import com.project.Farmobile.category.services.categoryRepo;

@Service
public class categoryService {
    private final categoryRepo categoryRepo;

    public categoryService(categoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public category findCategoryByName(String categoryName){
        return categoryRepo.findByCategoryName(categoryName);
    }

}
