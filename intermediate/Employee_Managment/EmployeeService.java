package com.sj.empmanagmentapplication;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeService {

    private final HashSet<Employee> empset = new HashSet<>();
    private final Scanner sc = new Scanner(System.in);

    public EmployeeService() {
        empset.add(new Employee(101, "Shital", 24, "Developer", "IT", 25000));
        empset.add(new Employee(102, "Meena", 26, "Tester", "CO", 57000));
        empset.add(new Employee(103, "Bob", 20, "DevOps Eng", "Admin", 5000));
        empset.add(new Employee(104, "Max", 27, "System Eng", "CO", 70000));
    }


    public void viewAllEmps() {
        if (empset.isEmpty()) {
            System.out.println(" No employees found.");
        } else {
            System.out.println(" Employee List:");
            for (Employee emp : empset) {
                System.out.println(emp);
            }
        }
    }


    public void viewEmp() {
        try {
            System.out.print(" Enter Employee ID: ");
            int id = sc.nextInt();
            boolean found = false;

            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    System.out.println(" Employee Found:");
                    System.out.println(emp);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(" Employee with ID " + id + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input. Please enter a valid number.");
            sc.nextLine();
        }
    }

    // Update employee
    public void updateEmployee() {
        try {
            System.out.print(" Enter Employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            boolean found = false;

            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    double salary = sc.nextDouble();

                    emp.setName(name);
                    emp.setSalary(salary);

                    System.out.println(" Employee updated successfully:");
                    System.out.println(emp);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(" Employee with ID " + id + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input. Please enter correct data types.");
            sc.nextLine();
        }
    }

    // Delete employee
    public void deleteEmp() {
        try {
            System.out.print(" Enter Employee ID to delete: ");
            int id = sc.nextInt();
            boolean found = false;
            Employee toDelete = null;

            for (Employee emp : empset) {
                if (emp.getId() == id) {
                    toDelete = emp;
                    found = true;
                    break;
                }
            }

            if (found) {
                empset.remove(toDelete);
                System.out.println(" Employee deleted successfully.");
            } else {
                System.out.println(" Employee with ID " + id + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input. Please enter a valid number.");
            sc.nextLine();
        }
    }


    public void addEmp() {
        try {
            System.out.print(" Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, age, designation, department, salary);
            empset.add(emp);

            System.out.println(" Employee added successfully:");
            System.out.println(emp);
        } catch (InputMismatchException e) {
            System.out.println(" Invalid input. Please enter correct data types.");
            sc.nextLine();
        }
    }
}
