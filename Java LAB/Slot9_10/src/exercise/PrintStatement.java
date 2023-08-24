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
public class PrintStatement implements ISyntax {

    public PrintStatement() {
    }

    @Override
    public void execute(String statement, int lineNumber, HashMap<String, Double> valueList) {
        if (!valueList.isEmpty()) {
            try {
                System.out.println(valueList.get(statement.toUpperCase()));
            } catch (Exception e) {
                System.out.println("Variable does not exist at line " + lineNumber + "!");
            }
        } else {
            System.out.println("Syntax error at line " + lineNumber + "!");
        }
    }

}
