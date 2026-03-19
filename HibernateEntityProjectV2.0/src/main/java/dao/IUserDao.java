package dao;

import pojos.User;

public interface IUserDao {
	String registerUser(User user);

	String assignNewRole(long userId, long roleId);
}
