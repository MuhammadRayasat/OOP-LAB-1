# OOP-LAB-1

Java practice programs for Object-Oriented Programming — Lab 1.
Each task is in its own folder with a single `Main.java` file that
contains all the classes for that task.

## Tasks

| # | Folder | Topic | Concepts covered |
|---|--------|-------|------------------|
| 1 | `Task1_MethodOverloadingOverriding` | Shape & Rectangle | Method overloading, method overriding, inheritance |
| 2 | `Task2_UniversitySystem` | University System | Inheritance, constructor overloading, static member, static method, method overriding |
| 3 | `Task3_EmployeeManager` | Employee & Manager | Inheritance, parameterized constructors, `super()`, method overriding |
| 4 | `Task4_BankingSystem` | Banking System | Method overriding (Savings vs Current accounts) |
| 5 | `Task5_PaymentSystem` | Payment System | Runtime polymorphism (Cash, Card, Online payments) |

## How to run

Requires JDK 8 or newer. From any task folder:

```bash
javac Main.java
java Main
```

Example (Task 1):

```bash
cd Task1_MethodOverloadingOverriding
javac Main.java
java Main
```

## Notes

- **Task 3 — why `super()` is used:** `Employee` has only a parameterized
  constructor (`name`, `salary`) and no no-arg constructor. When a `Manager`
  object is created, Java must first build the `Employee` part of it, but it
  cannot do that on its own because there is no default constructor to call.
  `super(name, salary)` explicitly calls `Employee`'s parameterized
  constructor, initializing the inherited fields before `Manager` adds its own
  `department` field. Without it, the code would not compile. It also avoids
  duplicating the initialization logic in the child class.

- **Task 5 — runtime polymorphism:** the `pay()` method is called on a
  `Payment` reference, but Java decides at runtime which child's version to
  run, based on the actual object — not the reference type.

## Structure

```
OOP-LAB-1/
├── README.md
├── Task1_MethodOverloadingOverriding/
│   └── Main.java
├── Task2_UniversitySystem/
│   └── Main.java
├── Task3_EmployeeManager/
│   └── Main.java
├── Task4_BankingSystem/
│   └── Main.java
└── Task5_PaymentSystem/
    └── Main.java
```
