package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import pojos.Address;

public class AssignUserAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AddressDaoImpl addressDao = new AddressDaoImpl();
			System.out.println("Enter user email : ");
			String email = sc.next();
			System.out.print("Enter Address Line1: ");
			String line1 = sc.nextLine();

			System.out.print("Enter Address Line2: ");
			String line2 = sc.nextLine();

			System.out.print("Enter City: ");
			String city = sc.nextLine();

			System.out.print("Enter State: ");
			String state = sc.nextLine();

			System.out.print("Enter Country: ");
			String country = sc.nextLine();

			System.out.print("Enter ZipCode: ");
			String zip = sc.nextLine();
			Address address = new Address(line1, line2,  city,  state,  country, zip);
			System.out.println(addressDao.assignUserAddress(email, address));

		} catch (Exception e) {

		}

	}

}
