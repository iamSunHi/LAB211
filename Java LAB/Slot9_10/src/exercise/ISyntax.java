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
public interface ISyntax {
    public void execute(String statement, int lineNumber, HashMap<String, Double> valueList);
}
