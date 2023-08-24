/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    private StudentManagement studentManagement = new StudentManagement();

    public static String[] optionsList = {"Create", "Find and Sort", "Update/Delete", "Report"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("WELCOME TO STUDENT MANAGEMENT", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choiceMain) {
        Scanner sc = new Scanner(System.in);
        String option;
        switch (choiceMain) {
            case 1:
//                studentManagement.createStudent();

                // Test
                ArrayList<String> courseName1 = new ArrayList<>();
                courseName1.add("Java");
                courseName1.add("C/C++");
                courseName1.add(".Net");
                studentManagement.getList().add(new Student("1", "doan", 1, courseName1));
                studentManagement.getList().add(new Student("2", "nhat", 2, courseName1));
                studentManagement.getList().add(new Student("3", "huy", 3, courseName1));
                ArrayList<String> courseName2 = new ArrayList<>();
                courseName2.add("Java");
                courseName2.add("C/C++");
                courseName2.add("Java");
                studentManagement.getList().add(new Student("4", "dinh", 4, courseName2));
                studentManagement.getList().add(new Student("5", "nhat", 5, courseName2));
                studentManagement.getList().add(new Student("6", "huy", 6, courseName2));
                break;
            case 2:
                if (studentManagement.getList().isEmpty()) {
                    System.out.println("Student list is empty!");
                    break;
                }
                System.out.print("What do you want?"
                        + "\n\t1 - Find"
                        + "\n\t2- Sort"
                        + "\nYour choice: "
                );
                option = sc.nextLine();
                switch (option) {
                    case "1":
                        studentManagement.findStudent();
                        break;
                    case "2":
                        studentManagement.sortList();
                        break;
                }
                break;
            case 3:
                if (studentManagement.getList().isEmpty()) {
                    System.out.println("Student list is empty!");
                    break;
                }

                System.out.print("Enter id of student you want to update/delete: ");
                String id = sc.nextLine();
                boolean isExist = false;

                for (int i = 0; i < studentManagement.getList().size(); i++) {
                    if (studentManagement.getList().get(i).getId().equals(id)) {
                        System.out.print("Do you want to update (U) or delete (D) student? ");
                        option = sc.nextLine();
                        switch (option) {
                            case "u":
                            case "U":
                                studentManagement.updateStudent(id, i);
                                break;
                            case "d":
                            case "D":
                                studentManagement.deleteStudent(id, i);
                                break;
                        }
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    System.out.println("Cannot find student with id \"" + id + "\"");
                }
                break;
            case 4:
                if (studentManagement.getList().isEmpty()) {
                    System.out.println("Student list is empty!");
                    break;
                }
                studentManagement.reportStudent();
                break;
        }
    }
}
