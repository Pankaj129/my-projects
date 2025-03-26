package test;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.*;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory factory = getFactory()) {
			System.out.println("hibernate up n running...!!!!!!!!!!!!"+factory);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
