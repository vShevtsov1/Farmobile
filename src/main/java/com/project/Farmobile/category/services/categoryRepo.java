package com.project.Farmobile.category.services;

import com.project.Farmobile.category.data.category;
import org.springframework.data.repository.CrudRepository;

public interface categoryRepo extends CrudRepository<category,Long> {
    category findByCategoryName(String name);
}
