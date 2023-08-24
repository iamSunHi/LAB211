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
public class StringAnalysis {
    private String input;

    public StringAnalysis(String input) {
        this.input = input;
    }

    public HashMap<String, List<Character>> analyze() {
        HashMap<String, List<Character>> result = new HashMap<>();
        List<Character> allCharacters = new ArrayList<>();
        List<Character> uppercaseCharacters = new ArrayList<>();
        List<Character> lowercaseCharacters = new ArrayList<>();
        List<Character> specialCharacters = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            allCharacters.add(ch);
            if (Character.isUpperCase(ch)) {
                uppercaseCharacters.add(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercaseCharacters.add(ch);
            } else {
                specialCharacters.add(ch);
            }
        }

        result.put("all", allCharacters);
        result.put("uppercase", uppercaseCharacters);
        result.put("lowercase", lowercaseCharacters);
        result.put("special", specialCharacters);

        return result;
    }
}
