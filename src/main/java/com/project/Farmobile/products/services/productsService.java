package com.project.Farmobile.products.services;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.products.data.DTO.productsSaveDTO;
import com.project.Farmobile.products.data.help.productsSaveStatus;
import com.project.Farmobile.products.data.products;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.project.Farmobile.products.services.productRepo;
import com.project.Farmobile.category.services.categoryService;

import java.util.List;

@Service
public class productsService {
    private final productRepo productRepo;
    private final ModelMapper modelMapper;
    private final categoryService categoryService;

    public productsService(productRepo productRepo,ModelMapper modelMapper,categoryService categoryService) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }
    public productsSaveStatus save(productsSaveDTO productsSaveDTO){
        products newProducts = productRepo.save(modelMapper.map(productsSaveDTO, products.class));
        if(newProducts ==null){
            return productsSaveStatus.FAILED;
        }
        else {
            return productsSaveStatus.OK;
        }
    }
    public List<products> findAllByCategory(String category){
        category categoryByName = categoryService.findCategoryByName(category);
        return productRepo.findAllByCategory(categoryByName);
    }
    public products findById(Long id){
        return productRepo.findById(id).get();
    }
}
