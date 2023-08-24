/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.util.HashMap;

/**
 *
 * @author Nhật Huy
 */
public class LetStatement implements ISyntax {

    public LetStatement() {
    }
    
    @Override
    public void execute(String statement, int lineNumber, HashMap<String, Double> valueList) {
        String[] components = statement.split(" ");
        
        double currentNumber = 0.0;
        double nextNumber = 0.0;
        
        
        for (int i = components.length - 1; i > 0; i--) {
            try {
                currentNumber = Double.parseDouble(components[i]);
            } catch (NumberFormatException e) {
                if (components[i].equals("=")) {
                    String variableName = components[i - 1].toUpperCase();
                    valueList.put(variableName, currentNumber);
                    i--;
                } else {
                    try {
                        nextNumber = Double.parseDouble(components[i - 1]);
                        currentNumber = calculate(currentNumber, components[i], nextNumber);
                        i--;
                    } catch (NumberFormatException e1) {
                        if (!valueList.isEmpty()) {
                            if (currentNumber == 0) {
                                currentNumber = valueList.get(components[i].toUpperCase());
                            }
                            else {
                                nextNumber = valueList.get(components[i - 1].toUpperCase());
                                currentNumber = calculate(currentNumber, components[i], nextNumber);
                                i--;
                            }
                        } else {
                            System.out.println("Syntax error at line " + lineNumber + "!");
                        }
                    }
                }
            }
        }
    }
    protected double calculate(double b, String operator, double a) {
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
        }
        return result;
    }
}
