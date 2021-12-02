package com.demo.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Roles;

@Repository("roleRepositories")
public interface RoleRepository extends CrudRepository<Roles, Integer> {

}
