/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equationSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    public static String[] optionsList = {"Calculate Superlative Equation", "Calculate Quadratic Equation"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

//    public static void main(String[] args) {
//        App m = new App("========= Equation Program =========", optionsList);
//        m.run();
//        System.out.println("\nEnd Program !");
//    }

    @Override
    public void execute(int choice) {
        double a = 0, b = 0, c = 0;
        boolean isCorrectType;

        ArrayList<Double> oddNumbers = new ArrayList<>();
        ArrayList<Double> evenNumbers = new ArrayList<>();
        ArrayList<Double> squareNumbers = new ArrayList<>();

        ArrayList<Double> tempList = new ArrayList<>();

        switch (choice) {
            case 1:
                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        isCorrectType = true;
                        System.out.print("Enter A: ");
                        a = sc.nextDouble();
                        sc.nextLine();
                    } catch (Exception e) {
                        isCorrectType = false;
                        System.out.println("Please input number!");
                    }
                } while (!isCorrectType);
                tempList.add(a);
                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        isCorrectType = true;
                        System.out.print("Enter B: ");
                        b = sc.nextDouble();
                    } catch (Exception e) {
                        isCorrectType = false;
                        System.out.println("Please input number!");
                    }
                } while (!isCorrectType);
                tempList.add(b);

                SuperlativeEquation se = new SuperlativeEquation();
                List<Double> seList = se.calculateSuperlativeEquation(a, b);
                System.out.print("Solution: ");
                if (seList == null) {
                    System.out.print("no solution");
                } else if (seList.isEmpty()) {
                    System.out.print("infinitely many solutions");
                } else {
                    seList.forEach((Double number) -> {
                        System.out.print(number + " ");
                        tempList.add(number);
                    });
                }

                tempList.forEach((Double number) -> {
                    if (number != 0) {
                        if (number % 2 != 0) {
                            oddNumbers.add(number);
                        } else {
                            evenNumbers.add(number);
                        }
                        if ((double) Math.pow((int) Math.sqrt(number), 2) == number) {
                            squareNumbers.add(number);
                        }
                    }
                });

                System.out.print("\nNumber is Odd: ");
                oddNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                System.out.print("\nNumber is Even: ");
                evenNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                System.out.print("\nNumber is Square: ");
                squareNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                break;
            case 2:
                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        isCorrectType = true;
                        System.out.print("Enter A: ");
                        a = sc.nextDouble();
                    } catch (Exception e) {
                        isCorrectType = false;
                        System.out.println("Please input number!");
                    }
                } while (!isCorrectType);
                tempList.add(a);
                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        isCorrectType = true;
                        System.out.print("Enter B: ");
                        b = sc.nextDouble();
                    } catch (Exception e) {
                        isCorrectType = false;
                        System.out.println("Please input number!");
                    }
                } while (!isCorrectType);
                tempList.add(b);
                do {
                    try {
                        Scanner sc = new Scanner(System.in);
                        isCorrectType = true;
                        System.out.print("Enter C: ");
                        c = sc.nextDouble();
                    } catch (Exception e) {
                        isCorrectType = false;
                        System.out.println("Please input number!");
                    }
                } while (!isCorrectType);
                tempList.add(c);

                QuadraticEquation qe = new QuadraticEquation(a, b, c);
                List<Double> qeList = qe.calculateQuadraticEquation();
                System.out.print("Solution: ");
                if (qeList == null) {
                    System.out.print("no solution");
                } else if (qeList.isEmpty()) {
                    System.out.print("infinitely many solutions");
                } else {
                    if (qeList.size() == 1) {
                        tempList.add(qeList.get(0));
                        System.out.print(qeList.get(0));
                    } else {
                        tempList.add(qeList.get(0));
                        tempList.add(qeList.get(1));
                        System.out.print("x1 = " + qeList.get(0) + " and x2 = " + qeList.get(1));
                    }
                }

                tempList.forEach((Double number) -> {
                    if (number != 0) {
                        if (number % 2 != 0) {
                            oddNumbers.add(number);
                        } else {
                            evenNumbers.add(number);
                        }
                        if ((double) Math.pow((int) Math.sqrt(number), 2) == number) {
                            squareNumbers.add(number);
                        }
                    }
                });

                System.out.print("\nNumber is Odd: ");
                oddNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                System.out.print("\nNumber is Even: ");
                evenNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                System.out.print("\nNumber is Square: ");
                squareNumbers.forEach((number) -> {
                    System.out.print(number + " ");
                });
                break;
        }
    }
}
