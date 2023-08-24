/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageFruitShop;
import controller.Validation;
import java.util.Scanner;

/**
 *
 * @author bravee06
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageFruitShop mg = new ManageFruitShop();
        while(true){
        System.out.println("1. Create fruit ");
        System.out.println("2. View order");
        System.out.println("3. Shopping ");
        System.out.println("4. Exit");
        int choice = sc.nextInt();
        switch(choice){
            case 1: mg.createProduct();
                break;
            case 2: mg.viewOrders();
                break;
            case 3:
                mg.shopping();
            case 4: 
                break;
        }
    }
}
}
