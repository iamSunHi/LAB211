/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidateManagement;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class Internship extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Internship() {
    }

    public Internship(String id, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, String majors, String semester, String universityName) {
        super(id, firstName, lastName, birthDate, address, phoneNumber, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Internship createInternship() {
        Scanner sc = new Scanner(System.in);
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phoneNumber;
        String email;
        String majors;
        String semester;
        String universityName;

        System.out.println("\n=========== CREATE INTERNSHIP CANDIDATE ===========");

        System.out.print("- ID: ");
        id = sc.nextLine();

        System.out.print("- First name: ");
        firstName = sc.nextLine();

        System.out.print("- Last name: ");
        lastName = sc.nextLine();

        do {
            System.out.print("- Birth date: ");
            birthDate = sc.nextInt();
            sc.nextLine();
        } while (!this.isValid(this.isValidBirthDate(birthDate)));

        System.out.print("- Address: ");
        address = sc.nextLine();

        do {
            System.out.print("- Phone number: ");
            phoneNumber = sc.nextLine();
        } while (!this.isValid(this.isValidPhone(phoneNumber)));

        do {
            System.out.print("- Email: ");
            email = sc.nextLine();
        } while (!this.isValid(this.isValidEmail(email)));

        System.out.print("- Majors: ");
        majors = sc.nextLine();

        System.out.print("- Semester: ");
        semester = sc.nextLine();

        System.out.print("- University name: ");
        universityName = sc.nextLine();

        return new Internship(id, firstName, lastName, birthDate, address, phoneNumber, email, majors, semester, universityName);
    }
    
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " | "
                + this.getBirthDate() + " | "
                + this.getAddress() + " | "
                + this.getEmail() + " | "
                + "Majors: " + this.majors + " | "
                + "Semester: " + this.semester + " | "
                + "University name: " + this.universityName;
    }

    // Getters & Setters
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
