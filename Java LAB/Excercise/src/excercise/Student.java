/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise;

import java.util.ArrayList;

/**
 *
 * @author Nhật Huy
 */
public class Student extends Person {
    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String address) {
        super(name, address);
    }
    
    @Override
    public String toString() {
        if (numCourses == 0)
            return "\nStudent: " + super.toString();
        else {
            String temp = "";
            for (int i = 0; i < this.numCourses; i++) {
                temp += "\n\t- " + this.courses.get(i) + ": " + this.grades.get(i);
            }
            return "\nStudent: " + super.toString() + temp 
                    + "\nAverage grade: " + this.getAverageGrade();
        }
    }
    
    public void addCourseGrade(String course, int grade) {
        if (numCourses <= 30) {
            this.courses.add(course);
            this.grades.add(grade);
            this.numCourses++;
        }
        else {
            System.out.println("\nA student takes no more than 30 courses!");
        }
    }

    public void printGrades() {
        System.out.println(this.toString());
        for (int i = 0; i < this.numCourses; i++) {
            System.out.println("\t-" + this.courses.get(i) + ": " + this.grades.get(i));
        }
    }
    
    public double getAverageGrade() {
        int sum = 0;
        for (int grade: this.grades) {
            sum += grade;
        }
        return (double)Math.round((double)sum / this.numCourses * 100) / 100;
    }
}
