package tester;

import static java.time.LocalDate.parse;

import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class UserRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// String firstName, String lastName, String email, String password, LocalDate
			// dob, RoleEnum userRole
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter following user details: firstName, lastName, email, password, dob");
			String user = userDao.registerUser(new User(sc.next(), sc.next(), sc.next(), sc.next(), parse(sc.next())));
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
