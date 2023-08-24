/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise;

/**
 *
 * @author Nhật Huy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student st = new Student("Nhật Huy", "FPT University");
        for (int i = 0; i < 30; i++) {
            st.addCourseGrade("LAB " + (i + 1), (int)Math.round(Math.random() * (10 - 1) + 1));
        }
        System.out.println(st.toString());
        
        Teacher tc = new Teacher("Sun Hi", "FPT Edu");
        tc.addCourse("LAB");
        tc.addCourse("PRF");
        tc.addCourse("PRO");
        tc.addCourse("Java");
        tc.addCourse("Javascript");
        tc.addCourse("MAD");
        System.out.println(tc.toString());
    }
}
