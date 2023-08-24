/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public abstract class Menu {
    private String title;
    private final ArrayList<String> optionsList = new ArrayList<>();

    public Menu() {
    }

    public Menu(String title, String[] optionsList) {
        this.title = title;
        this.optionsList.addAll(Arrays.asList(optionsList));
    }
    
    public int getChoice() {
        this.display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please choice one option: ");
        return sc.nextInt();
    }
    
    public void display() {
        System.out.println("\n" + title);
        for (int i = 0; i < this.optionsList.size(); i++) {
            System.out.println((i + 1) + ". " + this.optionsList.get(i));
        }
        System.out.println((this.optionsList.size() + 1) + ". Exit");
        System.out.println("====================================");
    }
    
    public abstract void execute(int choice);
    
    public void run() {
        while (true) {
            int n = getChoice();
            this.execute(n);
            if (n > this.optionsList.size()) {
                break;
            }
        }
    }
}
