/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Nhật Huy
 */
public class Main extends Menu {
    
    public static String[] optionsList = {"Sort algorithm", "Search algorithm", "Change base number", "Letter and Character count"};
    public Main(String title, String[] optionsList) {
        super(title, optionsList);
    }
    
    public static void main(String[] args) {
        Main m = new Main("M E N U", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                Algorithm.displaySort();
                break;
            case 2:
                Algorithm.displaySearch();
                break;
            case 3:
                Algorithm.displayChangeBaseNumber();
                break;
            case 4:
                Algorithm.displayLetterCount();
                break;
        }
    }
    
    
}
