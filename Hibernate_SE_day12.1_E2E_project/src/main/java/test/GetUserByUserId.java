package test;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetUserByUserId {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter user id");
			System.out.println(userDao.getUserByUserId(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
