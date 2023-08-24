/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigData;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class LargeNumberMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String num1 = sc.nextLine();

        System.out.print("Enter the second number: ");
        String num2 = sc.nextLine();

        LargeNumberMultiplier multiplier = new LargeNumberMultiplier(num1, num2);
        BigInteger result = multiplier.multiply();

        System.out.println("Result: " + result.toString());
    }
}
