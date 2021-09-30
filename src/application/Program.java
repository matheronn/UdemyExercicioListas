package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		List<Employee> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idp = sc.nextInt();

		Employee employee = list.stream().filter(x -> x.getId() == idp).findFirst().orElse(null);

		if (employee == null) {
			System.out.println("This id does not exist!");
			System.out.println();
		} else {
			System.out.println();
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			employee.increaseSalary(percent);
			System.out.println();
		}

		System.out.println("List of Employees: ");
		for (Employee x : list) {
			System.out.println(x);
		}

		sc.close();
	}
}
