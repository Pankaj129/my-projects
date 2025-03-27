package test;

import java.time.LocalDate;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class UserRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println(
					"Enter user details : \n1.name\n2.email\n3.password\n4.confirm password\n5.user role\n6.register amount\n7.register date(yyMMdd)");
			System.out.println(userDao.registerUser(new User(sc.next(), sc.next(), sc.next(), sc.next(),
					Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
