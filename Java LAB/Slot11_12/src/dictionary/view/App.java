/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.view;

import dictionary.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {
    Controller controller = new Controller();
    
    public static String[] optionsList = {"Add Word", "Delete Word", "Translate"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("======== Dictionary program ========", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                this.displayAddWord();
                break;
            case 2:
                this.displayDeleteWord();
                break;
            case 3:
                this.displayTranslateWord();
                break;
        }
    }
    
    public void displayAddWord() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n------------- Add Word -------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        System.out.print("Enter Vietnamese: ");
        String vi = scanner.nextLine();
        
        controller.addWord(eng, vi);
    }

    public void displayDeleteWord() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n------------ Delete Word ------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        
        controller.deleteWord(eng);
    }

    public void displayTranslateWord() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n------------ Translate --------------");
        System.out.print("Enter English: ");
        String eng = scanner.nextLine();
        String vi = controller.translateWord(eng);
        displayTranslationResult(vi);
    }

    public void displayTranslationResult(String vi) {
        if (!vi.isEmpty()) {
            System.out.println("Vietnamese: " + vi);
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }
}
