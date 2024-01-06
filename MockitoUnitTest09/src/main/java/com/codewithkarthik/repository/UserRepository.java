package com.codewithkarthik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codewithkarthik.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT * from User WHERE user_name = :nameparam")
	public User getByName(@Param("nameparam") String name);

}
