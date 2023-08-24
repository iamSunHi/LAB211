/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class StudentManagement extends Student {

    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentManagement() {
    }

    public StudentManagement(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void display() {
        this.studentList.forEach((Student student) -> {
            System.out.println(student.getName() + " | " + student.getSemester() + " | " + student.getCourseName().toString());
        });
    }

    public void createStudent() {
        Scanner sc = new Scanner(System.in);
        String option;

        System.out.println("\nCREATE STUDENT");
        System.out.println("You have to create at least 10 students!");
        for (int i = 1; i <= 10; i++) {
            String id;
            String name;
            int semester;
            String course;
            ArrayList<String> courseName = new ArrayList<>();

            System.out.println("\nStudent " + i + ":");
            System.out.print("\t- Id: ");
            id = sc.nextLine();
            System.out.print("\t- Name: ");
            name = sc.nextLine();
            System.out.print("\t- Semester: ");
            semester = sc.nextInt();
            sc.nextLine();
            do {
                System.out.print("\t- Course name: ");
                course = sc.nextLine();
                courseName.add(course);
                System.out.println("Do you want to add more course(Y/N)? ");
                option = sc.nextLine();
            } while (option.toUpperCase().equals("Y"));

            this.studentList.add(new Student(id, name, semester, courseName));
        }
        do {
            System.out.print("Do you wan to continue(Y/N)? ");
            option = sc.nextLine();
            if (option.toUpperCase().equals("N")) {
                break;
            }

            String id;
            String name;
            int semester;
            String course;
            ArrayList<String> courseName = new ArrayList<>();

            System.out.println("\nStudent:");
            System.out.print("\t- Id: ");
            id = sc.nextLine();
            System.out.print("\t- Name: ");
            name = sc.nextLine();
            System.out.print("\t- Semester: ");
            semester = sc.nextInt();
            do {
                System.out.print("\t- Course name: ");
                course = sc.nextLine();
                courseName.add(course);
                System.out.println("Do you want to add more course(Y/N)? ");
                option = sc.nextLine();
            } while (option.toUpperCase().equals("Y"));

            this.studentList.add(new Student(id, name, semester, courseName));
        } while (true);
    }

    public void findStudent() {
        Scanner sc = new Scanner(System.in);
        String name;
        int count = 0;

        System.out.println("\nFIND STUDENT");
        System.out.print("Enter name of student you want to find: ");
        name = sc.nextLine();
        for (Student student : this.studentList) {
            if (student.getName().equals(name)) {
                System.out.println(student.getName() + " | " + student.getSemester() + " | " + student.getCourseName().toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Cannot find student with name \"" + name + "\"");
        }
    }

    public void sortList() {
        Collections.sort(this.studentList, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });

        display();
    }

    public void updateStudent(String id, int index) {
        Scanner sc = new Scanner(System.in);
        String name;
        int semester;
        ArrayList<String> courseName = new ArrayList<>();

        System.out.println("\nUPDATE STUDENT");
        System.out.println("Choose type(s) of information you want to update:"
                + "\n\t1 - Name"
                + "\n\t2 - Semester"
                + "\n\t3 - Course name"
        );
        System.out.print("Your choice(s): ");
        String choice = sc.nextLine();
        String choices[] = choice.split(" ");

        for (String c : choices) {
            switch (c) {
                case "1":
                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
                    this.studentList.get(index).setName(name);
                    break;
                case "2":
                    System.out.print("Enter new semester: ");
                    semester = sc.nextInt();
                    sc.nextLine();
                    this.studentList.get(index).setSemester(semester);
                    break;
                case "3":
                    String course;
                    do {
                        System.out.print("Enter new course name: ");
                        course = sc.nextLine();
                        courseName.add(course);
                        System.out.println("Do you want to add more course(Y/N)? ");
                        c = sc.nextLine();
                    } while (c.toUpperCase().equals("Y"));
                    this.studentList.get(index).setCourseName(courseName);
                    break;
            }
        }
        System.out.println("The student with id \"" + id + "\" has been updated!");
    }

    public void deleteStudent(String id, int index) {
        this.studentList.remove(index);
        System.out.println("The student with id \"" + id + "\" has been removed!");
    }

    public void reportStudent() {
        ArrayList<String> duplicateCourses = new ArrayList<>();

        System.out.println("\nREPORT");
        this.studentList.forEach((student) -> {
            for (String course : student.getCourseName()) {
                if (!duplicateCourses.contains(course)) {
                    System.out.println(student.getName() + " | " + course + " | " + Collections.frequency(student.getCourseName(), course));
                    duplicateCourses.add(course);
                }
            }
            duplicateCourses.clear();
        });
    }

    public ArrayList<Student> getList() {
        return this.studentList;
    }
}
