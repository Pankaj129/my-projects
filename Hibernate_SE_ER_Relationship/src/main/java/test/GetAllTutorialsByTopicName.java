package test;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;

public class GetAllTutorialsByTopicName {

    public static void main(String[] args) {
        try (SessionFactory factory = getFactory();
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Please enter the topic name: ");
            String topic = sc.nextLine();

            // Creating DAO instance
            TutorialDaoImpl tutDao = new TutorialDaoImpl();

            // Fetch and print all tutorials
            tutDao.getAllTutorialsByTopicName(topic)
                  .forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Error fetching tutorials: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
