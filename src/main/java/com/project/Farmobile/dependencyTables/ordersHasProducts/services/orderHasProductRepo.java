package com.project.Farmobile.dependencyTables.ordersHasProducts.services;

import com.project.Farmobile.dependencyTables.ordersHasProducts.data.orderHasProduct;
import com.project.Farmobile.embedded.orderHasProductId;
import org.springframework.data.repository.CrudRepository;

public interface orderHasProductRepo extends CrudRepository<orderHasProduct, orderHasProductId> {
}
