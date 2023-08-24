/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerProgram;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class Calculator {

    public void performNormalCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Normal Calculator -----");

        double memory = 0.0;

        System.out.print("Enter number: ");
        double number1 = Double.parseDouble(sc.nextLine());
        memory += number1;

        while (true) {

            System.out.print("Enter Operator: ");
            String operator = sc.nextLine();

            if (operator.equals("=")) {
                System.out.println("Result: " + memory);
                break;
            }

            if (!operator.matches("[+\\-*/^]")) {
                System.out.println("Please input (+, -, *, /, ^)");
                continue;
            }

            System.out.print("Enter number: ");
            double number2 = Double.parseDouble(sc.nextLine());
            
            memory = calculate(memory, operator, number2);
            
            System.out.println("Memory: " + memory);
        }

    }

    public void performBMICalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- BMI Calculator -----");

        double weight = 0.0;
        boolean validWeight = false;
        while (!validWeight) {
            System.out.print("Enter Weight(kg): ");
            String weightInput = sc.nextLine();
            try {
                weight = Double.parseDouble(weightInput);
                validWeight = true;
            } catch (NumberFormatException e) {
                System.out.println("Weight must be a number.");
            }
        }

        double height = 0.0;
        boolean validHeight = false;
        while (!validHeight) {
            System.out.print("Enter Height(cm): ");
            String heightInput = sc.nextLine();
            try {
                height = Double.parseDouble(heightInput);
                validHeight = true;
            } catch (NumberFormatException e) {
                System.out.println("Height must be a number.");
            }
        }

        BMI bmiCalculator = new BMI(weight, height);
        double bmi = bmiCalculator.calculateBMI();
        String bmiStatus = bmiCalculator.getBMIStatus();

        System.out.printf("BMI Number: %.2f%n", bmi);
        System.out.println("BMI Status: " + bmiStatus);
    }

    public double calculate(double a, String operator, double b) {
        double result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "^":
                result = Math.pow(a, b);
                break;
            default:
                System.out.println("Invalid operator.");
                break;
        }

        return result;
    }
}
