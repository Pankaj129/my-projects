package test;

import org.hibernate.SessionFactory;
import dao.TutorialDaoImpl;
import static utils.HibernateUtils.*;

public class GetAllTutorials {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        try (SessionFactory factory = getFactory()) {
            System.out.println("List of all Tutorials:");
            
            // Creating DAO instance
            TutorialDaoImpl tutDao = new TutorialDaoImpl();
            
            // Fetch and print all tutorials
            tutDao.getAllTutorials().forEach(System.out::println);
            
        } catch (Exception e) {
            System.err.println("Error fetching tutorials: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
