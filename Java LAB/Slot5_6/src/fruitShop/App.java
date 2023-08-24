/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitShop;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {
    private final FruitShopManagement fruitShopManagement = new FruitShopManagement();

    public static String[] optionsList = {"Create fruit", "View order", "Shopping"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

//    public static void main(String[] args) {
//        App m = new App("WELCOME TO FRUIT SHOP MANAGEMENT", optionsList);
//        m.run();
//        System.out.println("\nEnd Program !");
//    }

    @Override
    public void execute(int choiceMain) {
        Scanner sc = new Scanner(System.in);
        String option;
        switch (choiceMain) {
            case 1:
                fruitShopManagement.createProduct();
                break;
            case 2:
                fruitShopManagement.viewOrders();
                break;
            case 3:
                fruitShopManagement.shopping();
                break;
        }
    }
}
