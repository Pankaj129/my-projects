package test;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetAllUsersList {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("List of below users : ");
			userDao.getAllUsers().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
