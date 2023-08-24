/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workerInformation.view;

import java.util.Scanner;
import workerInformation.controller.WorkerManagementSystem;
import workerInformation.model.Worker;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    private final WorkerManagementSystem controller = new WorkerManagementSystem();

    public static String[] optionsList = {"Add Worker", "Up salary", "Down salary", "Display Information salary"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("======== Worker Management =========", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                this.addWorkerView();
                break;
            case 2:
                this.upDownSalary();
                break;
            case 3:
                this.upDownSalary();
                break;
            case 4:
                this.displaySalaryRecords();
                break;
        }
    }

    private void addWorkerView() {
        Scanner sc = new Scanner(System.in);
        boolean isValid;
        System.out.println("\n--------- Add Worker ----------");

        System.out.print("Enter Code: ");
        String id = sc.nextLine();
        if (controller.isWorkerIdExists(id)) {
            System.out.println("Worker with the same ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = 0;
        isValid = true;
        do {
            try {
                age = sc.nextInt();
                sc.nextLine();
                if (age < 18 || age > 50) {
                    System.out.println("Invalid age. Age must be between 18 and 50.");
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid type of input!");
                isValid = false;
            }
        } while (!isValid);

        System.out.print("Enter Salary: ");
        double salary = 0;
        isValid = true;
        do {
            try {
                salary = sc.nextDouble();
                sc.nextLine();
                if (salary <= 0) {
                    System.out.println("Invalid salary. Salary must be greater than 0.");
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid type of input!");
                isValid = false;
            }
        } while (!isValid);

        System.out.print("Enter work location: ");
        String workLocation = sc.nextLine();

        controller.addWorker(id, name, age, salary, workLocation);
        System.out.println("Worker added successfully.");
    }

    private void upDownSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------- Up/Down Salary --------");
        System.out.print("Enter Code: ");
        String id = sc.nextLine();

        int temp = controller.findWorkerById(id);
        if (temp == -1) {
            System.out.println("Worker not found.");
            return;
        }

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        controller.updateSalary(temp, salary);
        System.out.println("Salary updated successfully.");
    }

    public void displaySalaryRecords() {
        boolean isExist = false;
        System.out.println("\n--------------------Display Information Salary-----------------------");
        System.out.printf("%-10s%-20s%-10s%-12s%-10s\n", "Code", "Name", "Age", "Salary", "Status");

        for (Worker worker: controller.getWorkers()) {
            if (!worker.getSalaryStatus().equals("NULL")){
                System.out.printf("%-10s%-20s%-10d%-12.2f%-10s\n", worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getSalaryStatus());
                isExist = true;
            }
        }
        
        if (!isExist)
            System.out.println("NULL!");
    }
}
