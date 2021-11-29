package com.demo.repositories.user;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Users;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<Users, Integer> {

}
