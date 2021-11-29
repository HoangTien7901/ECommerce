package com.demo.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Images;

@Repository("")
public interface ImageRepository extends CrudRepository<Images, Integer> {

	
}
