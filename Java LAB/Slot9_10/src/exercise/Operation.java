/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class Operation {

    private final ArrayList<String> inputList = new ArrayList<>();

    private HashMap<String, Double> valueList = new HashMap<>();

    public Operation() {
    }

    public void run() {
        if (!this.inputList.get(0).toUpperCase().equals("BEGIN") || !this.inputList.get(this.inputList.size() - 1).toUpperCase().equals("END")) {
            System.out.println("Syntax error!");
            return;
        }

        for (int i = 1; i < this.inputList.size() - 1; i++) {
            String line = this.inputList.get(i);

            if (line.toUpperCase().startsWith("LET")) {
                String variableAndValue = line.substring(line.indexOf(" ") + 1);
                LetStatement let = new LetStatement();
                let.execute(variableAndValue, i + 1, valueList);
            } else if (line.toUpperCase().startsWith("PRINT")) {
                String expression = line.substring(line.indexOf(" ") + 1);
                PrintStatement print = new PrintStatement();
                print.execute(expression, i + 1, valueList);
            } else {
                System.out.println("Syntax error at line " + (i + 1) + "!");
            }

        }
    }

    public void getInput() {
        String inputLine = "END";

        do {
            Scanner sc = new Scanner(System.in);
            inputLine = this.normalizeLine(sc.nextLine());
            inputList.add(inputLine);
        } while (!inputLine.toUpperCase().equals("END"));
    }

    private String normalizeLine(String line) {
        line = line.trim();

        // Add the necessary spaces
        String[] parts = line.split("\\s*(?<=[+\\-*/=])|(?=[+\\-*/=])\\s*");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i > 0 && parts[i].isEmpty()) {
                continue;
            }
            sb.append(parts[i]).append(" ");
        }

        // Remove extra spaces
        line = sb.toString().trim().replaceAll("\\s+", " ");

        return line;
    }

    public double getValue(String key) {
        return this.valueList.get(key);
    }

    public HashMap<String, Double> getValueList() {
        return valueList;
    }

    public void setValueList(HashMap<String, Double> valueList) {
        this.valueList = valueList;
    }
}
