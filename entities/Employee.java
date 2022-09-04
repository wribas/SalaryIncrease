package entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {
// properties
    private int numberEmployees, id;
    private double salary;
    private String name;
    int increaseID = 0;
    List<Integer> idEmployee = new ArrayList<>();
    List<String> nameEmployee = new ArrayList<>();
    List<Double> salaryEmployee = new ArrayList<>();

// constructors
    public Employee() {}

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
// add list method
    public void addList(int id, String name, double salary){
        idEmployee.add(id);
        nameEmployee.add(name);
        salaryEmployee.add(salary);

    }
// ID verification method
    public int checkId(int id) {
        List<Integer> result = idEmployee.stream().filter(x -> x == id).toList();
        for (int j:result) {
            if (j == id){
                return 1;
            }
            else{
                return 0;
            }
        }
        return id;
    }
// increase salary
    public double increaseSalary(int id){
        increaseID = idEmployee.indexOf(id);
        return salaryEmployee.get(idEmployee.indexOf(id));
    }

// get and set
    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salaryEmployee.add(increaseID, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
