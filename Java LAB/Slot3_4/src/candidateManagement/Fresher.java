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
public class Fresher extends Candidate {

    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String id, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phoneNumber, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher createFresher() {
        Scanner sc = new Scanner(System.in);
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phoneNumber;
        String email;
        int graduationDate;
        String graduationRank;
        String education;

        System.out.println("\n=========== CREATE FRESHER CANDIDATE ===========");

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

        System.out.print("- Graduated time: ");
        graduationDate = sc.nextInt();
        sc.nextLine();

        do {
            System.out.print("- Rank of Graduation: ");
            graduationRank = sc.nextLine();
        } while (!this.isValid(this.isValidRank(graduationRank)));

        System.out.print("- University where graduated: ");
        education = sc.nextLine();

        return new Fresher(id, firstName, lastName, birthDate, address, phoneNumber, email, graduationDate, graduationRank, education);
    }
    
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " | "
                + this.getBirthDate() + " | "
                + this.getAddress() + " | "
                + this.getEmail() + " | "
                + "Graduation date: " + this.graduationDate + " | "
                + "Graduation rank: " + this.graduationRank + " | "
                + "Education: " + this.education;
    }

    // Validation
    public boolean isValidRank(String graduationRank) {
        return (graduationRank.equals("Excellence")
                || graduationRank.equals("Good")
                || graduationRank.equals("Fair")
                || graduationRank.equals("Poor"));
    }

    // Getters & Setters
    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
