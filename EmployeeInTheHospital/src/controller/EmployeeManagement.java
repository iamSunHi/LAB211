
package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Employee;
import model.DoctorEmployee;
import model.NurseEmployee;

public class EmployeeManagement {
    
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
        employees.add(new DoctorEmployee("1", "Employee1", "123", 1.5f, 1, "doctor", 2));
        employees.add(new NurseEmployee("2", "Emplopyee2", "456", 1.5f));
        employees.add(new NurseEmployee("3", "Employee3", "789", 1.5f, "hospital", 3));
    }

    public void createEmployee() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Choose the type of employee to create:");
            System.out.println("1. Doctor");
            System.out.println("2. Nurse");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter employee ID:");
            String id = scanner.nextLine();

            System.out.println("Enter employee name:");
            String name = scanner.nextLine();

            System.out.println("Enter employee address:");
            String address = scanner.nextLine();

            System.out.println("Enter employee coefficients salary:");
            float coefficientsSalary = scanner.nextFloat();
            scanner.nextLine();

            if (type == 1) {
                System.out.println("Enter doctor level:");
                int level = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter doctor major:");
                String major = scanner.nextLine();

                System.out.println("Enter doctor position allowance:");
                int positionAllowance = scanner.nextInt();
                scanner.nextLine();

                DoctorEmployee doctor = new DoctorEmployee(id, name, address, coefficientsSalary, level, major, positionAllowance);
                employees.add(doctor);
            } else if (type == 2) {
                System.out.println("Enter nurse department:");
                String department = scanner.nextLine();

                System.out.println("Enter nurse overtime hours:");
                int overtimeHours = scanner.nextInt();
                scanner.nextLine();

                NurseEmployee nurse = new NurseEmployee(id, name, address, coefficientsSalary, department, overtimeHours);
                employees.add(nurse);
            } else {
                System.out.println("Invalid employee type!");
            }

            System.out.println("Do you want to continue (Y/N)?");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
    }

    public void viewAllEmployees() {
        employees.forEach((employee) -> {
            System.out.println(employee);
        });
    }

    public void viewEmployeesByAddress(String address) {
        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getAddress().equalsIgnoreCase(address)) {
                System.out.println(employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found with the given address.");
        }
    }
}
