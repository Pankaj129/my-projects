package test;

import static utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetSelectedDetailsByRegDate {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter \n1. start date\n2. end date : ");
			userDao.getUsersDetailsByRegDate(parse(sc.next()), parse(sc.next()))
					.forEach(u -> System.out.println(u.getname() + " " + u.getRegAmount() + " " + u.getUserRole()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
