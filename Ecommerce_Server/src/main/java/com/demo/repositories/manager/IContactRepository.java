package com.demo.repositories.manager;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Contacts;

public interface IContactRepository extends CrudRepository<Contacts, Integer> {
}
