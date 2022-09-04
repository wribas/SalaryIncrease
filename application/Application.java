package application;

/*
* Write a program to read an integer N and then the data (id, name and salary) of N employees.
* There must be no repetition of id.
* Then, increase the salary of a given employee by X percent.
* For this, the program must read an id and the value X.
* If the id informed does not exist, display a message and abort the operation.
* At the end, show the updated list of employees, as shown in the examples.
*/

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        int numberEmployees;
        int id = 0;
        double salary = 0.0;
        String name = " ";

        System.out.print("How many employees will be registered? ");
        numberEmployees = scanner.nextInt();

        for (int i = 1; i <= numberEmployees; i++) {
            System.out.printf("Employee #%d%n", i);
// getting ID and check
            System.out.print("ID: ");
            id = scanner.nextInt();
            while (employee.checkId(id) == 1){
                System.out.print("ID: ");
                id = scanner.nextInt();
            }
// getting name
            scanner.nextLine();
            System.out.print("Name: ");
            name = scanner.nextLine();
// getting salary
            System.out.print("Salary: ");
            salary = scanner.nextDouble();
//add to lists
            employee.addList(id, name, salary);
        }
// increase the salary of a given employee by X percent
        System.out.print("Enter employee ID the will have salary increase: ");
        id = scanner.nextInt();
        double salaryToIncrease = employee.increaseSalary(id);
        System.out.print("Enter the percentage: ");
        double percent = scanner.nextDouble();
        double increase = salaryToIncrease + (salaryToIncrease * percent);
        employee.setSalary(increase);

        System.out.println("List of employees: ");

    }
}
