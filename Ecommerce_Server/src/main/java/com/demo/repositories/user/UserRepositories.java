package com.demo.repositories.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.entities.Users;
import com.demo.models.UserId;

@Repository("userRepositories")
public interface UserRepositories extends CrudRepository<Users, Integer> {

	@Query("select new com.demo.models.UserId(id, roles.id, fullname) from Users")
	public UserId getIdUser();
	
	
}
