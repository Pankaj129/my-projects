package test;

import static utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class UpdateUserImageByUserId {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter userId and image path  : \n");
			System.out.println(userDao.updateImageByUserId(sc.nextLong(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
