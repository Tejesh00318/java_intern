package com.sj.empmanagmentapplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();

        while (true) {
            System.out.println("**************** Welcome To Employee Management System ****************");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add Employee");
                    employeeService.addEmp();
                    break;
                case 2:
                    System.out.println("View Employee");
                    employeeService.viewEmp();
                    break;
                case 3:
                    System.out.println("Update Employee");
                    employeeService.updateEmployee();
                    break;
                case 4:
                    System.out.println("Delete Employee");
                    employeeService.deleteEmp();
                    break;
                case 5:
                    System.out.println("View All Employees");
                    employeeService.viewAllEmps();
                    break;
                case 6:
                    System.out.println("Thank you for using the application!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }
        }
    }
}
