package com.project.Farmobile.orders.services;

import com.project.Farmobile.dependencyTables.ordersHasProducts.data.DTO.orderHasProductDTO;
import com.project.Farmobile.dependencyTables.ordersHasProducts.services.orderHasProductService;
import com.project.Farmobile.orders.data.DTO.orderCreateDTO;
import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.products.data.products;
import com.project.Farmobile.users.data.users;
import com.project.Farmobile.users.services.userService;
import org.springframework.stereotype.Service;
import com.project.Farmobile.orders.services.ordersRepo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ordersService {
    private final ordersRepo ordersRepo;
    private final userService userService;
    private final orderHasProductService orderHasProductService;

    public ordersService(ordersRepo ordersRepo,userService userService,orderHasProductService orderHasProductService) {
        this.ordersRepo = ordersRepo;
        this.userService = userService;
        this.orderHasProductService= orderHasProductService;
    }
    public orders createOrder(String email,orderCreateDTO orderCreateDTO){
        users users = userService.getUserByMail(email);
        orders orders = new orders(new Date(), orderCreateDTO.getSumm(), orderCreateDTO.getPhoneNumber(),orderCreateDTO.getAdress(),users);
        ordersRepo.save(orders);
        Map<products, Integer> productCountMap = new HashMap<>();

        for (products product : orderCreateDTO.getProducts()) {
            productCountMap.put(product, productCountMap.getOrDefault(product, 0) + 1);
        }
        orderHasProductService.saveProducts(new orderHasProductDTO(orders,productCountMap));
        return orders;
    }
}
