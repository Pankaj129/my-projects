package test;

import static utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetSelectedUserByRegDate {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter registration date  : ");
			userDao.getSelectedUserByDate(parse(sc.next())).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
