package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;

public class GetAllTutorialDetailsWithTopic {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			TutorialDaoImpl tutDao = new TutorialDaoImpl();

			System.out.println("Topic with tutorial : ");

			tutDao.getTutorialsAndTopicDetails().forEach(tut->{
				System.out.println("Tutorial : "+tut);
				System.out.println("Topics : "+tut.getSelectedTopic());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
