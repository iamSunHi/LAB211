/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Nhật Huy
 */
public class BaseNumber {
    private String inputString;

    public BaseNumber() {
    }

    public BaseNumber(String inputString) {
        inputString = inputString.trim();
        while (inputString.contains(" ")) {
            inputString = inputString.replaceAll(" ", "");
        }
        this.inputString = inputString;
    }
    
    public void displayResult(String result) {
        System.out.println("\nResult: " + result);
    }
    
    public String binToOther(int outputBase) {
        int temp = Integer.parseInt(this.inputString, 2);
        switch (outputBase) {
            case 2:
                return Integer.toBinaryString(temp);
            case 3:
                return Integer.toHexString(temp).toUpperCase();
        }
        return "";
    }
    
    public String decToOther(int outputBase) {
        int temp = Integer.parseInt(this.inputString);
        switch (outputBase) {
            case 1:
                return Integer.toString(temp);
            case 3:
                return Integer.toHexString(temp).toUpperCase();
        }
        return "";
    }
    
    public String hexToOther(int outputBase) {
        int temp = Integer.parseInt(this.inputString, 16);
        switch (outputBase) {
            case 1:
                return Integer.toBinaryString(temp);
            case 2:
                return Integer.toString(temp);
        }
        return "";
    }
}
