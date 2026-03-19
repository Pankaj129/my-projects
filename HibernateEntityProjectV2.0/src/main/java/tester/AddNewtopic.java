package tester;

import java.util.Scanner;

import dao.TopicDaoImpl;
import pojos.Topic;

public class AddNewtopic {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			TopicDaoImpl topicDao = new TopicDaoImpl();
			System.out.println("Enter toic name ");
			String topicName = sc.nextLine();
			System.out.println("Enter toic description ");
			String topicDesc = sc.nextLine();
			Topic topic = new Topic(topicName, topicDesc);
			System.out.println(topicDao.addNewTopic(topic));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
