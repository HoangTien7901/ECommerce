package com.demo.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Contacts;

@Repository("contactRepositories")
public interface ContactRepositories extends CrudRepository<Contacts, Integer> {

}
