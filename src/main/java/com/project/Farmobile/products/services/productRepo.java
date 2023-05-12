package com.project.Farmobile.products.services;

import com.project.Farmobile.category.data.category;
import com.project.Farmobile.products.data.products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface productRepo extends CrudRepository<products,Long> {
    List<products> findAllByCategory(category category);

}
