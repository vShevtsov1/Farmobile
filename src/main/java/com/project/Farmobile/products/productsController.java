package com.project.Farmobile.products;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.products.data.DTO.productsSaveDTO;
import com.project.Farmobile.products.data.help.productsSaveStatus;
import com.project.Farmobile.products.data.products;
import org.springframework.web.bind.annotation.*;
import com.project.Farmobile.products.services.productsService;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class productsController {
    private final productsService productsService;

    public productsController(productsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/create")
    private productsSaveStatus createProducts(@RequestBody productsSaveDTO productsSaveDTO){
        try {
            return productsService.save(productsSaveDTO);
        }
        catch (Exception e){
            return productsSaveStatus.FAILED;
        }
    }
    @PostMapping("/get/category")
    private List<products> findAllByCategory(@RequestParam(name = "category") String category){
        return productsService.findAllByCategory(category);
    }
    @GetMapping("/get/id")
    private products findProductById(@RequestParam(name="id")Long id){
        return productsService.findById(id);
    }
}
