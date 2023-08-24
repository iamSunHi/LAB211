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
public class App extends Menu {
    
    private Candidate candidate = new Candidate();

    public static String[] optionsList = {"Experience", "Fresher", "Internship", "Searching"};
    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }
    
    public static void main(String[] args) {
        App m = new App("M E N U", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        Scanner sc = new Scanner(System.in);
        String option;
        int first = candidate.getCandidatesList().size();
        
        switch (choice) {
            case 1:
                first = candidate.getCandidatesList().size();
                do {
//                    candidate.addCadiate(new Experience("01", "Doan Dinh", "Nhat Huy", (int) (Math.random() * (2023 - 1900 + 1) + 1900), "da nang", "0705909123", "huyde170468@fpt.edu.vn", 20, "none"));
                    candidate.addCadiate(new Experience().createExperience());
                    System.out.print("Do you want to continue (Y/N)? ");
                    option = sc.next().replaceAll(" ", "");
                } while (option.toUpperCase().equals("Y"));
                
                System.out.println("\nList of Experience candidates who are recently created: ");
                for (int i = first; i < candidate.getCandidatesList().size(); i++) {
                    System.out.println(candidate.getCandidatesList().get(i).toString());
                }
                break;
            case 2:
                first = candidate.getCandidatesList().size();
                do {
//                    candidate.addCadiate(new Fresher("01", "Doan Dinh", "Nhat Huy", (int) (Math.random() * (2023 - 1900 + 1) + 1900), "da nang", "0705909123", "huyde170468@fpt.edu.vn", 2025, "Good", "FPT University"));
                    candidate.addCadiate(new Fresher().createFresher());
                    System.out.print("Do you want to continue (Y/N)? ");
                    option = sc.next().replaceAll(" ", "");
                } while (option.toUpperCase().equals("Y"));
                
                System.out.println("\nList of Fresher candidates who are recently created: ");
                for (int i = first; i < candidate.getCandidatesList().size(); i++) {
                    System.out.println(candidate.getCandidatesList().get(i).toString());
                }
                break;
            case 3:
                first = candidate.getCandidatesList().size();
                do {
//                    candidate.addCadiate(new Internship("01", "Doan Dinh", "Nhat Huy", (int) (Math.random() * (2023 - 1900 + 1) + 1900), "da nang", "0705909123", "huyde170468@fpt.edu.vn", "Software Engineer", "2021 - 2025", "FPT University"));
                    candidate.addCadiate(new Internship().createInternship());
                    System.out.print("Do you want to continue (Y/N)? ");
                    option = sc.next().replaceAll(" ", "");
                } while (option.toUpperCase().equals("Y"));
                
                System.out.println("\nList of Internship candidates who are recently created: ");
                for (int i = first; i < candidate.getCandidatesList().size(); i++) {
                    System.out.println(candidate.getCandidatesList().get(i).toString());
                }
                break;
            case 4:
                SearchCadidate.execute(candidate);
                break;
        }
    }
    
}
