package test;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class ChangePassword {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter the user Id and password  : ");
			System.out.println(userDao.changePassword(sc.nextLong(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
