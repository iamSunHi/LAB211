/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class Algorithm {

    protected int list[] = null;

    public Algorithm() {
    }

    public Algorithm(int numberRange) {
        this.list = new int[numberRange];
        for (int i = 0; i < numberRange; i++) {
            this.list[i] = (int) Math.round(Math.random() * (numberRange - 1) + 1);
        }
    }

    public void swap(int tempList[], int i, int j) {
        int temp = tempList[i];
        tempList[i] = tempList[j];
        tempList[j] = temp;
    }

    public static void displaySort() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of array: ");
        int numberRange = sc.nextInt();
        SortAlgorithm sort = new SortAlgorithm(numberRange);

        System.out.print("\nSort Algorithm:");
        System.out.print(
                "\n\t1. Bubble Sort"
                + "\n\t2. Quick Sort"
                + "\nYour choice: "
        );
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("\nBubble Sort");
                sort.bubbleSortExecute();
                sort.displayResult();
                break;
            case 2:
                System.out.println("\nQuick Sort");
                sort.quickSortExecute();
                sort.displayResult();
                break;
        }
    }

    public static void displaySearch() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter number of array: ");
        int numberRange = sc.nextInt();

        System.out.print("\nSearch Algorithm:");
        System.out.print(
                "\n\t1. Linear Search"
                + "\n\t2. Binary Search"
                + "\nYour choice: "
        );
        int option = sc.nextInt();
        System.out.print("\nEnter the number you want to search: ");
        int n = sc.nextInt();

        
        SearchAlgorithm search = new SearchAlgorithm(numberRange, n);
        switch (option) {
            case 1:
                System.out.println("\nLinear Search");
                search.displayResult(search.linearSearchExecute());
                break;
            case 2:
                System.out.println("\nBinary Search");
                search.displayResult(search.binarySearchExecute());
                break;
        }
    }

    public static void displayChangeBaseNumber() {
        Scanner sc = new Scanner(System.in);
        int inputBase;
        int outputBase;
        String inputString;
        BaseNumber base;

        do {
            System.out.println("\nExplanation of selection:\t1 - Binary\t2 - Decimal\t3 - Hexadecimal");
            System.out.print("\nChoose the base number input: ");
            inputBase = sc.nextInt();
        } while (inputBase < 1 || inputBase > 3);
        
        switch (inputBase) {
            case 1:
                do {
                    System.out.print("\nChoose the base number output: ");
                    outputBase = sc.nextInt();
                } while (outputBase < 2 || outputBase > 3);
                
                sc.nextLine();
                System.out.print("Enter a binary string: ");
                inputString = sc.nextLine();
                base = new BaseNumber(inputString);

                switch (outputBase) {
                    case 2:
                        base.displayResult(base.binToOther(outputBase));
                        break;
                    case 3:
                        base.displayResult(base.binToOther(outputBase));
                        break;
                }
                break;
            case 2:
                do {
                    System.out.print("\nChoose the base number output: ");
                    outputBase = sc.nextInt();
                } while (outputBase != 1 && outputBase != 3);

                sc.nextLine();
                System.out.print("Enter a decimal number: ");
                inputString = sc.nextLine();
                base = new BaseNumber(inputString);

                switch (outputBase) {
                    case 1:
                        base.displayResult(base.decToOther(outputBase));
                        break;
                    case 3:
                        base.displayResult(base.decToOther(outputBase));
                        break;
                }
                break;
            case 3:
                do {
                    System.out.print("\nChoose the base number output: ");
                    outputBase = sc.nextInt();
                } while (outputBase < 1 || outputBase > 2);

                sc.nextLine();
                System.out.print("Enter a hexadecimal string: ");
                inputString = sc.nextLine();
                base = new BaseNumber(inputString);

                switch (outputBase) {
                    case 1:
                        base.displayResult(base.hexToOther(outputBase));
                        break;
                    case 2:
                        base.displayResult(base.hexToOther(outputBase));
                        break;
                }
                break;
            default:
                System.out.println("Wrong type of input base, please choose again!");
                break;
        }
    }

    public static void displayLetterCount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter your content: ");
        String inputString = sc.nextLine();

        LetterAndCharacterCount str = new LetterAndCharacterCount(inputString);
        str.displayResult();
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

}
