// Lab Task 2: University System Using OOP Principles
// Demonstrates:
//   - Inheritance: Teacher and Student inherit from Person.
//   - Constructor overloading: Student and Teacher can be created
//     with different sets of arguments.
//   - Static member: universityName is shared by all persons.
//   - Static method: showUniversityInfo() belongs to the class, not objects.
//   - Method overriding: displayInfo() is redefined in both subclasses.

class Person {
    String name;
    int age;

    // Static member: one shared copy for all Person objects.
    static String universityName = "City University";

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Static method: called on the class, not on an object.
    static void showUniversityInfo() {
        System.out.println("University: " + universityName);
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;
    double salary;

    // Constructor 1: all details given.
    Teacher(String name, int age, String subject, double salary) {
        super(name, age);
        this.subject = subject;
        this.salary = salary;
    }

    // Constructor 2 (overloaded): salary defaults to 0.
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
        this.salary = 0;
    }

    @Override
    void displayInfo() {
        System.out.println("Teacher -> Name: " + name + ", Age: " + age
                + ", Subject: " + subject + ", Salary: Rs " + salary);
    }
}

class Student extends Person {
    String rollNo;
    double marks;

    // Constructor 1: all details given.
    Student(String name, int age, String rollNo, double marks) {
        super(name, age);
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Constructor 2 (overloaded): marks default to 0.
    Student(String name, int age, String rollNo) {
        super(name, age);
        this.rollNo = rollNo;
        this.marks = 0;
    }

    @Override
    void displayInfo() {
        System.out.println("Student -> Name: " + name + ", Age: " + age
                + ", Roll No: " + rollNo + ", Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        // Static method called on the class (no object needed).
        Person.showUniversityInfo();
        System.out.println();

        // Constructor overloading: same class, different arguments.
        Teacher teacher1 = new Teacher("Ayesha Khan", 35, "OOP", 120000);
        Teacher teacher2 = new Teacher("Bilal Ahmed", 29, "Database");
        Student student1 = new Student("Ali Raza", 20, "CS-101", 88.5);
        Student student2 = new Student("Sara Malik", 19, "CS-102");

        // Method overriding: each subclass shows its own displayInfo().
        teacher1.displayInfo();
        teacher2.displayInfo();
        student1.displayInfo();
        student2.displayInfo();

        // Static member is shared: changing it once affects everyone.
        System.out.println("\nShared static member: " + Person.universityName);
    }
}
