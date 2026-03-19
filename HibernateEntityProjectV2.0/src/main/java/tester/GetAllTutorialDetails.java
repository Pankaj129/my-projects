package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;

public class GetAllTutorialDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			TutorialDaoImpl tutDao = new TutorialDaoImpl();
			System.out.println(" All Tutorials as follow : ");
			tutDao.getAllTutorials().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
