// Lab Task 3: Employee and Manager
// Demonstrates:
//   - Inheritance: Manager extends Employee.
//   - Parameterized constructors in both classes.
//   - super(): calling the parent constructor from the child constructor.
//   - Method overriding: Manager redefines displayDetails().
//
// Why is super() used in the Manager constructor?
// ------------------------------------------------
// Employee has only a parameterized constructor (name, salary) and no
// no-arg constructor. When a Manager object is created, Java must first
// build the Employee part of it — but it cannot do that on its own because
// there is no default constructor to call. super(name, salary) explicitly
// calls Employee's parameterized constructor, initializing the inherited
// name and salary fields before Manager adds its own department field.
// Without super(...), the code would not compile. It also avoids
// duplicating the initialization logic in the child class.

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee -> Name: " + name + ", Salary: Rs " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, double salary, String department) {
        super(name, salary); // initialize the Employee part first
        this.department = department;
    }

    @Override
    void displayDetails() {
        System.out.println("Manager -> Name: " + name + ", Salary: Rs " + salary
                + ", Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Usman Ali", 80000);
        Manager manager = new Manager("Ayesha Khan", 150000, "IT");

        employee.displayDetails();
        manager.displayDetails();

        // Parent reference holding a child object: overridden method runs.
        Employee ref = manager;
        System.out.print("Via Employee reference: ");
        ref.displayDetails();
    }
}
