import java.util.Scanner;

public class Company {

	public static void main(String[] args) {

		Employee emp;
		emp = new Employee();
		emp.accept();
		emp.disp();

	}
}

class Employee {
	String name;
	int rollNo;
	double salary;

	void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name : ");
		name = sc.next();
		System.out.println("Enter your rollNo : ");
		rollNo = sc.nextInt();
		System.out.println("Enter your salary : ");
		salary = sc.nextDouble();
		sc.close();
	}

	void disp() {

		System.out.println("\nName : " + name + "\nrollNo : " + rollNo + "\nsalary : " + salary);
	}

}
