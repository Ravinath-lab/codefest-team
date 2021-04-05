package com.codefest.noizies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codefest.noizies.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUserId(int id);
	User findUserByEmail(String email);
	
	@Query("select u from User u where u.email = ?1 and u.password = ?2 ")
	User findUserByAuth(String email,String password);
}
