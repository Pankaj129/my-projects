package thecuriouscoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Problem14 {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Abhishek", "IT", 50000),
				new Employee("Ankit", "IT", 70000), new Employee("Rahul", "HR", 40000),
				new Employee("Tina", "HR", 45000), new Employee("Esha", "Finance", 60000),
				new Employee("Naman", "Finance", 55000), new Employee("Sachit", "IT", 80000),
				new Employee("Pushp", "Marketing", 50000), new Employee("Sumit", "Marketing", 52000)));

		Map<String, Optional<Employee>> highSalDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, 
						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

		highSalDept.forEach((dept, empOptional) -> {
			empOptional.ifPresent(emp -> System.out.printf("%-10s : %s ($%.2f) %n", dept, emp.getName(), (double)emp.getSalary()));
		});

	}

}
