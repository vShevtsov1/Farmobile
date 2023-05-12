package com.project.Farmobile.photo.services;

import com.project.Farmobile.photo.data.photo;
import org.springframework.data.repository.CrudRepository;

public interface photoRepo extends CrudRepository<photo,Long> {
}
