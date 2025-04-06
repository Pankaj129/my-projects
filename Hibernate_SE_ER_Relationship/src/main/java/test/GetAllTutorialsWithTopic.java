package test;

import org.hibernate.SessionFactory;
import dao.TutorialDaoImpl;
import static utils.HibernateUtils.*;

public class GetAllTutorialsWithTopic {
    public static void main(String[] args) {
        try (SessionFactory factory = getFactory()) {
            System.out.println("List of all Tutorials and Topics:");

            // Creating DAO instance
            TutorialDaoImpl tutDao = new TutorialDaoImpl();

            // Fetch and print all tutorials along with their topics
            tutDao.getAllTutorialsWithTopic().forEach(tutorial -> {
                System.out.println("Tutorial Details: " + tutorial);
                
                // Fetching topic using getSelectedTopic() method
                if (tutorial.getSelectedTopic() != null) {
                    System.out.println("Topic Details: " + tutorial.getSelectedTopic());
                } else {
                    System.out.println("No Topic assigned.");
                }
            });

        } catch (Exception e) {
            System.err.println("Error fetching tutorials: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
