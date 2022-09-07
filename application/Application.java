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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many employees will be registered?");
        int n = scanner.nextInt();
        List<Employee> list = new ArrayList<>(); //interface need class to be instanced

        double percentage;

// get employees data

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.printf("Employee #%d%n: ", i+1);

            System.out.print("Id: ");
            Integer id = scanner.nextInt();
            while (hasId(list, id)) {
                System.out.print("Id already taken. Try again: ");
                id = scanner.nextInt();
            }

            System.out.print("Name: ");
            scanner.next();
            String name = scanner.nextLine();

            System.out.print("Salary: ");
            Double salary = scanner.nextDouble();

            Employee emp = new Employee(name, id, salary);
            list.add(emp);
        }

        // increase salary
        System.out.print("Enter the employee ID that will have salary increase: ");
        int idSalary = scanner.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        //Integer pos = hasID(list, idSalary);

        if (emp == null){
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            percentage = scanner.nextDouble();
            emp.increaseSalary(percentage);
        }

        // list employees
        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : list) {
            System.out.println(e);
        }

        scanner.close();
    }

    // function
    /*public static Integer hasID(List<Employee> list2, int id){
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }*/

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}