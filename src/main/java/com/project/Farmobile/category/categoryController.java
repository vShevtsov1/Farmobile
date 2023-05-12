package com.project.Farmobile.category;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.category.services.categoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class categoryController {
    private final categoryService categoryService;

    public categoryController(categoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public category getCategoryByName(@RequestParam(name = "category") String category){
        return categoryService.findCategoryByName(category);
    }
}
