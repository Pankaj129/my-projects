package test;

import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class UserRegistration {

	public static void main(String[] args) {
		try(@SuppressWarnings("unused")
		SessionFactory factory = getFactory();Scanner sc = new Scanner(System.in);) {
			UserDaoImpl userDao = new UserDaoImpl();
			//String firstName, String lastName, String email, String password, LocalDate dob, Role role
			System.out.println("Enter User deatils : \n1. First Name\n2. Last Name\n3. Email\n4. Password\n5. Date of Birth\n6. Role");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), parse(sc.next()), valueOf(sc.next().toUpperCase()));
			System.out.println(userDao.RegisterUser(user));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
