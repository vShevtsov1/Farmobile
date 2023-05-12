package com.project.Farmobile.orders.services;

import com.project.Farmobile.orders.data.orders;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ordersRepo extends CrudRepository<orders, Long> {

}
