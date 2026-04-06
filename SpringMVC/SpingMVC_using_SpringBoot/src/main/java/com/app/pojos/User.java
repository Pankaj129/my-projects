package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@Entity
@Table(name = "users_tbl")
public class User extends BaseEntity {

	@Column(length = 30, nullable = false)
	private String firstname;

	@Column(length = 30, nullable = false)
	private String lastname;

	@Column(length = 30, nullable = false)
	private String email;

	@Column(length = 30, nullable = false)
	private String password;

	@Column(nullable = false)
	private LocalDate registerDate;

	@Enumerated(EnumType.STRING)
	private RoleEnum role;

}
