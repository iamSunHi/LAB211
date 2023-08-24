/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidateManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class SearchCadidate extends Candidate {
    private static ArrayList<Candidate> result = new ArrayList<>();

    public SearchCadidate() {
    }
    
    public static void execute(Candidate candidate) {
        Scanner sc = new Scanner(System.in);
        String name;
        int type;
        
        candidate.displayCandidates();
        
        System.out.println("\n=========== CREATE FRESHER CANDIDATE ===========");
        System.out.print("Input Candidate name (first name or last name): ");
        name = sc.nextLine();
        System.out.print("Input type of candidate (0: Experience | 1: Fresher | 2: Intern): ");
        type = sc.nextInt();
        
        switch (type) {
            case 0:
                candidate.getExperienceCandidates().forEach((Candidate e) -> {
                    if (e.getFirstName().toLowerCase().contains(name.toLowerCase()) || e.getLastName().toLowerCase().contains(name.toLowerCase())) {
                        result.add(e);
                    }
                });
                break;
            case 1:
                candidate.getFresherCandidates().forEach((Candidate f) -> {
                    if (f.getFirstName().toLowerCase().contains(name.toLowerCase()) || f.getLastName().toLowerCase().contains(name.toLowerCase())) {
                        result.add(f);
                    }
                });
                break;
            case 2:
                candidate.getInternshipCandidates().forEach((Candidate i) -> {
                    if (i.getFirstName().toLowerCase().contains(name.toLowerCase()) || i.getLastName().toLowerCase().contains(name.toLowerCase())) {
                        result.add(i);
                    }
                });
                break;
        }
        
        if (result.isEmpty()) {
            System.out.println("\nCannot found any candidate with name \"" + name + "\"!");
        }
        else {
            System.out.println("\nThere are " + result.size() + " candidates found:");
            result.forEach((Candidate c) -> {
                System.out.println(c.toString());
            });
        }
    }
}
