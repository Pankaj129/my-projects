package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(length = 30)
	private String name;
	@Column(length = 30, unique = true)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name = "user_role")
	private Role userRole;
	@Column(name = "reg_amount")
	private double regAmount;
	@Column(name = "reg_date", nullable = false)
	private LocalDate regDate;
	@Lob
	private byte[] image;

	public User() {
		super();
		System.out.println("in ctor of user " + getClass());
	}

	public User(String name, String email, String password, String confirmPassword, Role userRole, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	public User(String name, Role userRole, double regAmount) {
		super();
		this.name = name;
		this.userRole = userRole;
		this.regAmount = regAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userRole=" + userRole
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
