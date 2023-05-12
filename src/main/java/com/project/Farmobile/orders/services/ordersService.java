package com.project.Farmobile.orders.services;

import com.project.Farmobile.dependencyTables.ordersHasProducts.data.DTO.orderHasProductDTO;
import com.project.Farmobile.dependencyTables.ordersHasProducts.data.orderHasProduct;
import com.project.Farmobile.dependencyTables.ordersHasProducts.services.orderHasProductService;
import com.project.Farmobile.orders.data.DTO.orderCreateDTO;
import com.project.Farmobile.orders.data.DTO.orderDTO;
import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.products.data.products;
import com.project.Farmobile.users.data.DTO.userDTO;
import com.project.Farmobile.users.data.users;
import com.project.Farmobile.users.services.userService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.project.Farmobile.orders.services.ordersRepo;

import java.util.*;

@Service
public class ordersService {
    private final ordersRepo ordersRepo;
    private final userService userService;
    private final orderHasProductService orderHasProductService;
    private final ModelMapper modelMapper;

    public ordersService(ordersRepo ordersRepo, userService userService, orderHasProductService orderHasProductService, ModelMapper modelMapper) {
        this.ordersRepo = ordersRepo;
        this.userService = userService;
        this.orderHasProductService = orderHasProductService;
        this.modelMapper = modelMapper;
    }

    public orders createOrder(String email, orderCreateDTO orderCreateDTO){
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
    public Iterable<orders> getAll(){
        return ordersRepo.findAll();
    }
    public orderDTO getById(Long ordersID){
        orders orders = ordersRepo.findById(ordersID).get();
        userDTO userDTO = modelMapper.map(orders.getUsers(),userDTO.class);
        List<orderHasProduct> orderHasProducts = orderHasProductService.getByOrder(orders);
        List<products> products = new ArrayList<>();
        for (orderHasProduct ordersProducts:orderHasProducts) {
            products.add(ordersProducts.getProducts());
        }
        return new orderDTO(orders.getIdOrders(),orders.getDate(),orders.getSumm(),orders.getPhoneNumber(),orders.getAdress(),userDTO,products);
    }
}
