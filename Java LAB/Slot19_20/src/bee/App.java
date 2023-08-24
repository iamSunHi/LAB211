/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bee;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BeeGame beeGame = new BeeGame();
        while (true) {
            System.out.println("1 - Create bee list");
            System.out.println("2 - Attack bees");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    beeGame.createBeeList();
                    beeGame.printBeeStatus();
                    break;
                case 2:
                    beeGame.attackBees();
                    beeGame.printBeeStatus();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
