/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizeInputString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nhật Huy
 */
public class NumberAnalysis {
    private String input;

    public NumberAnalysis(String input) {
        this.input = input;
    }

    public HashMap<String, List<Integer>> analyze() {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> perfectSquareNumbers = new ArrayList<>();

        String[] tokens = input.split("\\D+");
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            allNumbers.add(number);

            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }

            double sqrt = Math.sqrt(number);
            if (sqrt == (int) sqrt) {
                perfectSquareNumbers.add(number);
            }
        }

        result.put("all", allNumbers);
        result.put("even", evenNumbers);
        result.put("odd", oddNumbers);
        result.put("perfectSquare", perfectSquareNumbers);

        return result;
    }
}
