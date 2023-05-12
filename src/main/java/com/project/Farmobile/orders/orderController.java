package com.project.Farmobile.orders;

import com.project.Farmobile.orders.data.DTO.orderCreateDTO;
import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.orders.services.ordersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class orderController {
    private final ordersService ordersService;

    public orderController(ordersService ordersService) {
        this.ordersService = ordersService;
    }
    @PostMapping("/create")
    private orders createOrder(Authentication authentication, @RequestBody orderCreateDTO orderCreateDTO)
    {
       return ordersService.createOrder(authentication.getName(),orderCreateDTO);
    }
}
