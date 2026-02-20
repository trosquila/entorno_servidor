package com.daw.onepiece.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.daw.onepiece.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
	@Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
	UserEntity findByUserName(String userName);
}
