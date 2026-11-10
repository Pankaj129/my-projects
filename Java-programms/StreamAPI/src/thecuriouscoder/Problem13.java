package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem13 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(Arrays.asList( 
				new Employee("Abhishek", "IT", 50000),
				new Employee("Ankit", "IT", 70000), 
				new Employee("Rahul", "HR", 40000), 
				new Employee("Tina", "HR", 45000), 
				new Employee("Esha", "Finance", 60000), 
				new Employee("Naman", "Finance", 55000), 
				new Employee("Sachit", "IT", 80000),
				new Employee("Pushp", "Marketing", 50000), 
				new Employee("Sumit", "Marketing", 52000)
				));
		
		employees.stream()
				.collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.averagingInt(Employee::getSalary)))
				.forEach((dept, avg) -> System.out.printf("%-10s: %.2f%n", dept, avg));
		
		

	}

}
