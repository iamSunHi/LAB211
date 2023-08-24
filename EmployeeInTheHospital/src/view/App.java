package view;

import java.util.Scanner;

import controller.EmployeeManagement;

public class App extends Menu {

    EmployeeManagement manager = new EmployeeManagement();

    public static String[] optionsList = {"Create employee", "View all employee information and salary of all employees", "View the employee’s information has the same address that user input"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("WELCOME TO EMPLOYEE MANAGEMENT", optionsList);
        m.run();
        System.out.println("\nEnd!");
    }

    @Override
    public void execute(int choice) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                manager.createEmployee();
                break;
            case 2:
                manager.viewAllEmployees();
                break;
            case 3:
                System.out.println("Enter an address to search for employees:");
                String searchAddress = scanner.nextLine();
                manager.viewEmployeesByAddress(searchAddress);
                break;
        }
    }

}
