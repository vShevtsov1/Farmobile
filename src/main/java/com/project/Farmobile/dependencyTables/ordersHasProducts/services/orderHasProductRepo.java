package com.project.Farmobile.dependencyTables.ordersHasProducts.services;

import com.project.Farmobile.dependencyTables.ordersHasProducts.data.orderHasProduct;
import com.project.Farmobile.embedded.orderHasProductId;
import com.project.Farmobile.orders.data.orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface orderHasProductRepo extends CrudRepository<orderHasProduct, orderHasProductId> {
    List<orderHasProduct> findAllByOrder(orders orders);
}
