package com.project.Farmobile.dependencyTables.ordersHasProducts.services;

import com.project.Farmobile.dependencyTables.ordersHasProducts.data.DTO.orderHasProductDTO;
import com.project.Farmobile.dependencyTables.ordersHasProducts.data.orderHasProduct;
import com.project.Farmobile.dependencyTables.ordersHasProducts.services.orderHasProductRepo;
import com.project.Farmobile.embedded.orderHasProductId;
import com.project.Farmobile.products.data.products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class orderHasProductService {
    private final orderHasProductRepo orderHasProductRepo;

    public orderHasProductService(orderHasProductRepo orderHasProductRepo) {
        this.orderHasProductRepo = orderHasProductRepo;
    }
    public void saveProducts(orderHasProductDTO orderHasProductDTO){
        List<orderHasProduct> list = new ArrayList<>();
        for (Map.Entry<products,Integer>products : orderHasProductDTO.getProducts().entrySet()) {
            orderHasProductRepo.save(new orderHasProduct(new orderHasProductId(),products.getKey(),orderHasProductDTO.getOrder(),products.getValue()));
        }
    }
}
