package tester;

import static utils.HibernateUtils.getFactory;
import static java.time.LocalDate.parse;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

public class AddNewTutorialUnderAuthorAndTopic {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// String tutName, LocalDate pubDate, String content, int visit
			System.out.println("Enter the content ");
			String content = sc.nextLine();
			System.out.println("Enter  tutName, pubDate  & visit");
			Tutorial tut = new Tutorial(sc.next(), parse(sc.next()), content, sc.nextInt());
			System.out.println("Enter id of auther");
			Long authorId = sc.nextLong();
			System.out.println("Enter topicId");
			Long topicId = sc.nextLong();
			TutorialDaoImpl tutDao = new TutorialDaoImpl();
			System.out.println(tutDao.addTutorialByAuthorAndTopic(tut, authorId, topicId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
