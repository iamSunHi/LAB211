/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Nhật Huy
 */
public class LetterAndCharacterCount {

    private String inputString;

    public LetterAndCharacterCount() {
    }

    public LetterAndCharacterCount(String inputString) {
        inputString = inputString.trim();
        while (inputString.contains("  ")) {
            inputString = inputString.replaceAll("  ", " ");
        }
        this.inputString = inputString;
    }

    public void displayResult() {
        ArrayList<String> letterList = new ArrayList<>();
        ArrayList<String> letterNumber = this.countLetter();

        System.out.print("\n{");
        for (int i = 0; i < letterNumber.size(); i++) {
            String result[] = letterNumber.get(i).split(" ");
            letterList.add(result[0]);
            System.out.print(result[0] + " = " + result[1]);
            if (i < letterNumber.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        ArrayList<String> characterNumber = this.countCharacter(letterList);
        System.out.print("{");
        for (int i = 0; i < characterNumber.size(); i++) {
            String result[] = characterNumber.get(i).split(" ");
            System.out.print(result[0] + " = " + result[1]);
            if (i < characterNumber.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public ArrayList<String> countLetter() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(this.inputString, " ");

        while (st.hasMoreTokens()) {
            String tempString = st.nextToken();
            if (!result.contains(tempString)) {
                result.add(tempString);
                count.add(1);
            } else {
                int indexToChange = result.indexOf(tempString);
                int valueToChange = count.get(indexToChange) + 1;
                count.set(indexToChange, valueToChange);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            String valueToChange = result.get(i) + " " + count.get(i);
            result.set(i, valueToChange);
        }

        return result;
    }

    public ArrayList<String> countCharacter(ArrayList<String> letterList) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for (String letter : letterList) {
            String chars[] = letter.split("");
            for (String c : chars) {
                if (!result.contains(c)) {
                    result.add(c);
                    count.add(1);
                } else {
                    int indexToChange = result.indexOf(c);
                    int valueToChange = count.get(indexToChange) + 1;
                    count.set(indexToChange, valueToChange);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            String valueToChange = result.get(i) + " " + count.get(i);
            result.set(i, valueToChange);
        }

        return result;
    }
}
