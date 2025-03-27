package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.User;

class TestUserDao {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGetAllUsers() {
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> users = userDao.getAllUsers();
		users.forEach(System.out::println);
		assertEquals(11, users.size());
	}

}
