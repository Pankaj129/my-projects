package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class AssignUserRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter userid and roleid");
			Long userId = sc.nextLong();
			Long roleId = sc.nextLong();
			System.out.println(userDao.assignNewRole(userId, roleId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
