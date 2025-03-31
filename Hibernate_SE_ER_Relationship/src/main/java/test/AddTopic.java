package test;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TopicDaoImpl;
import pojos.Topic;

public class AddTopic {

	public static void main(String[] args) {
		try (@SuppressWarnings("unused")
		SessionFactory factory = getFactory(); Scanner sc = new Scanner(System.in);) {
			TopicDaoImpl topicDao = new TopicDaoImpl();

			System.out.println("Enter Topic deatils : \n1. Topic Name : ");
			String topicName = sc.nextLine();
			System.out.println("Enter Topic deatils : \n2. Topic Desciption : ");
			String topicDesc = sc.nextLine();
			Topic topic = new Topic(topicName, topicDesc);
			System.out.println(topicDao.addNewTopic(topic));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
