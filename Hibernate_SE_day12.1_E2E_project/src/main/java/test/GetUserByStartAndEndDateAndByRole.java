package test;

import static utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetUserByStartAndEndDateAndByRole {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter \n1. start date\n2. end date\n3. role : ");
			userDao.getUsersByDateAndRole(parse(sc.next()), parse(sc.next()), valueOf(sc.next().toUpperCase()))
					.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
