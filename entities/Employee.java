package entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Integer id;
    private Double salary;

    List<Employee> employee = new ArrayList<>();

    // constructors
    public Employee() {
    }

    public Employee(String name, Integer id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // method
    public void increaseSalary(double percentage){
        salary += salary * percentage / 100 ;
    }

// gets and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // to String

    @Override
    public String toString() {
        return
                id +
                ", " +
                name +
                ", " +
                String.format("%.2f", salary);
    }
}
