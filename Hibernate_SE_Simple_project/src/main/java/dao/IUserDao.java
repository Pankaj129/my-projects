package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
	String registerUser(User transientUser);

	User getUserByUserId(long userId);

	List<User> getAllUsers();

	List<User> getUsersByDateAndRole(LocalDate startDate, LocalDate endDate, Role userRole);

	List<String> getSelectedUserByDate(LocalDate date);

	List<User> getUsersDetailsByRegDate(LocalDate startDate, LocalDate endDate);

	String changePassword(long userId, String newPassword);

	String applyBulkDiscount(LocalDate date, double discount);

	String deleteUserByEmail(String email);

	String updateImageByUserId(long userId, String imagePath) throws IOException;
	
	String restoreImageByUserId(long userId, String imagePath) throws IOException;

}
