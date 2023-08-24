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
public class Teacher extends Person {
    private int numCourses = 0;
    private ArrayList<String> courses = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "\nTeacher: " + super.toString();
    }
    
//    @Override
//    public String toString() {
//        if (numCourses == 0)
//            return "\nTeacher: " + super.toString();
//        else {
//            String temp = "";
//            for (int i = 0; i < this.numCourses; i++) {
//                temp += "\n\t- " + this.courses.get(i);
//            }
//            return "\nTeacher: " + super.toString() + temp;
//        }
//    }
    
    public boolean addCourse(String course) {
        if (this.numCourses < 5) {
            if (!this.courses.contains(course)) {
                this.courses.add(course);
                this.numCourses++;
                return true;
            }
            return false;
        }
        else {
            System.out.println("\nA teacher teaches no more than 5 courses!");
            return false;
        }
    }
    
    public boolean removeCourse(String course) {
        return this.courses.remove(course);
    }
}
