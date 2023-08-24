/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizeInputString;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println("===== Analysis String program =====");
        System.out.println("Input String: " + input);

        NumberAnalysis numberAnalysis = new NumberAnalysis(input);
        StringAnalysis stringAnalysis = new StringAnalysis(input);

        // Perform analysis
        HashMap<String, List<Integer>> numberResult = numberAnalysis.analyze();
        HashMap<String, List<Character>> stringResult = stringAnalysis.analyze();

        // Display the analysis results
        System.out.println("\n----- Result Analysis -----");
        System.out.println("Perfect Square Numbers: " + numberResult.get("perfectSquare"));
        System.out.println("Odd Numbers: " + numberResult.get("odd"));
        System.out.println("Even Numbers: " + numberResult.get("even"));
        System.out.println("All Numbers: " + numberResult.get("all"));
        System.out.println("Uppercase Characters: " + stringResult.get("uppercase"));
        System.out.println("Lowercase Characters: " + stringResult.get("lowercase"));
        System.out.println("Special Characters: " + stringResult.get("special"));
        System.out.println("All Characters: " + stringResult.get("all"));
    }
}
