package test;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

public class AddNewTutorial {
    public static void main(String[] args) {
        // Try-with-resources ensures proper closing of resources
        try (
            SessionFactory factory = getFactory();
            Scanner sc = new Scanner(System.in)
        ) {
            // Validate if factory is initialized
            if (factory == null) {
                throw new RuntimeException("Hibernate SessionFactory is not initialized.");
            }

            TutorialDaoImpl tutorialDao = new TutorialDaoImpl();

            System.out.print("Enter Author Id: ");
            long authorId = sc.nextLong();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Topic Id: ");
            long topicId = sc.nextLong();
            sc.nextLine(); // Consume newline

            // Read tutorial details
            System.out.print("Enter Tutorial Name: ");
            String tutName = sc.nextLine();

            System.out.print("Enter Publish Date (YYYY-MM-DD): ");
            String dateInput = sc.next();
            LocalDate publishDate = LocalDate.parse(dateInput); // Ensure valid format

            System.out.print("Enter Visits: ");
            int visits = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Content: ");
            String content = sc.nextLine();

            // Call method and print result
            String result = tutorialDao.addNewTutorialByAuthorAndByTopic(
                new Tutorial(tutName, publishDate, visits, content), authorId, topicId
            );
            System.out.println("Tutorial added successfully: " + result);

        } catch (Exception e) {
            System.err.println("Error occurred while adding tutorial: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
