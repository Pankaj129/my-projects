package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailAndPasswod(String email, String password);

	@Query("select new com.app.User(id, fisrtname, lastname) from User u where u.role=:role")
	List<User> findByRole(RoleEnum role);

	long countByRole(RoleEnum role);

	boolean existsByEmail(String email);

}
