/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidateManagement;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Nhật Huy
 */
public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private int type;

    private ArrayList<Candidate> candidatesList = new ArrayList<>();
    private ArrayList<Candidate> experienceCandidates = new ArrayList<>();
    private ArrayList<Candidate> fresherCandidates = new ArrayList<>();
    private ArrayList<Candidate> internshipCandidates = new ArrayList<>();


    protected Candidate() {
    }

    protected Candidate(String id, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
    }

    protected void addCadiate(Candidate candidate) {
        this.candidatesList.add(candidate);
    }

    protected void displayCandidates() {
        for (Candidate c : this.candidatesList) {
            switch (c.getType()) {
                case 0:
                    this.experienceCandidates.add(c);
                    break;
                case 1:
                    this.fresherCandidates.add(c);
                    break;
                case 2:
                    this.internshipCandidates.add(c);
                    break;
            }
        }

        System.out.println("LIST OF CANDIDATES");
        System.out.println("=========== EXPERIENCE CANDIDATE ===========");
        this.experienceCandidates.forEach((Candidate e) -> {
            System.out.println(e.firstName + " " + e.lastName);
        });
        System.out.println("=========== FRESHER CANDIDATE ===========");
        this.fresherCandidates.forEach((Candidate f) -> {
            System.out.println(f.firstName + " " + f.lastName);
        });
        System.out.println("=========== INTERN CANDIDATE ===========");
        this.internshipCandidates.forEach((Candidate i) -> {
            System.out.println(i.firstName + " " + i.lastName);
        });
    }

    // Validation
    protected boolean isValid(boolean validation) {
        if (!validation) {
            System.out.println("Invalid value, please enter again!");
            return false;
        }
        return true;
    }

    protected boolean isValidBirthDate(int birthDate) {
        return (birthDate >= 1900 && birthDate <= Year.now().getValue());
    }

    protected boolean isValidPhone(String phoneNumber) {
        return (phoneNumber.length() >= 10);
    }

    protected boolean isValidEmail(String email) {
        String emailRegex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // ToString
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " | "
                + this.birthDate + " | "
                + this.address + " | "
                + this.email;
    }

    // Getters & Setters
    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected int getBirthDate() {
        return birthDate;
    }

    protected void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    protected String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected int getType() {
        return type;
    }

    protected void setType(int type) {
        this.type = type;
    }

    protected ArrayList<Candidate> getCandidatesList() {
        return candidatesList;
    }

    protected void setCandidatesList(ArrayList<Candidate> candidatesList) {
        this.candidatesList = candidatesList;
    }

    protected ArrayList<Candidate> getExperienceCandidates() {
        return experienceCandidates;
    }

    protected void setExperienceCandidates(ArrayList<Candidate> experienceCandidates) {
        this.experienceCandidates = experienceCandidates;
    }

    protected ArrayList<Candidate> getFresherCandidates() {
        return fresherCandidates;
    }

    protected void setFresherCandidates(ArrayList<Candidate> fresherCandidates) {
        this.fresherCandidates = fresherCandidates;
    }

    protected ArrayList<Candidate> getInternshipCandidates() {
        return internshipCandidates;
    }

    protected void setInternshipCandidates(ArrayList<Candidate> internshipCandidates) {
        this.internshipCandidates = internshipCandidates;
    }

}
