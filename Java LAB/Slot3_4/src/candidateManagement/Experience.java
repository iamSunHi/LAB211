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
public class Experience extends Candidate {

    private int yearOfExperience;
    private String proSkill;

    public Experience() {
    }

    public Experience(String id, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int yearOfExperience, String proSkill) {
        super(id, firstName, lastName, birthDate, address, phoneNumber, email, 0);
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }

    public Experience createExperience() {
        Scanner sc = new Scanner(System.in);
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String adddress;
        String phoneNumber;
        String email;
        int yearOfExperience;
        String proSkill;

        System.out.println("\n=========== CREATE EXPERIENCE CANDIDATE ===========");

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
        adddress = sc.nextLine();

        do {
            System.out.print("- Phone number: ");
            phoneNumber = sc.nextLine();
        } while (!this.isValid(this.isValidPhone(phoneNumber)));

        do {
            System.out.print("- Email: ");
            email = sc.nextLine();
        } while (!this.isValid(this.isValidEmail(email)));

        do {
            System.out.print("- Year of experience: ");
            yearOfExperience = sc.nextInt();
            sc.nextLine();
        } while (!this.isValidExperience(yearOfExperience));

        System.out.print("- Professional skill: ");
        proSkill = sc.nextLine();

        return new Experience(id, firstName, lastName, birthDate, adddress, phoneNumber, email, yearOfExperience, proSkill);
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " | "
                + this.getBirthDate() + " | "
                + this.getAddress() + " | "
                + this.getEmail() + " | "
                + "Year Of Experience: " + this.yearOfExperience + " | "
                + "Pro Skill: " + this.proSkill;
    }
    
    

    // Validation
    public boolean isValidExperience(int yearOfExperience) {
        return (yearOfExperience >= 0 && yearOfExperience <= 100);
    }

    // Getters & Setters
    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
