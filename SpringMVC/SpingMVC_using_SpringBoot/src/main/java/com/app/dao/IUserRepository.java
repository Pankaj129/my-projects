package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailAndPassword(String email, String password);

	List<User> findByRole(RoleEnum role);

	long countByRole(RoleEnum role);

	boolean existsByEmail(String email);

}
