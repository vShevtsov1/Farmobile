package com.project.Farmobile.orders;

import com.project.Farmobile.orders.data.DTO.orderCreateDTO;
import com.project.Farmobile.orders.data.DTO.orderDTO;
import com.project.Farmobile.orders.data.orders;
import com.project.Farmobile.orders.services.ordersService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get-all")
    private Iterable<orders> findAll(){
        return ordersService.getAll();
    }
    @PostMapping("/id")
    private orderDTO getById(@RequestParam(name = "orderId") Long orders){
        return ordersService.getById(orders);
    }
}
