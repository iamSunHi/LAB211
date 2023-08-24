/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerProgram;


/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    Calculator cal = new Calculator();
    public static String[] optionsList = {"Normal Calculator", "BMI Calculator"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

    public static void main(String[] args) {
        App m = new App("Calculator Program", optionsList);
        m.run();
        System.out.println("\nEnd Program !");
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                cal.performNormalCalculator();
                break;
            case 2:
                cal.performBMICalculator();
                break;
        }
    }

}
