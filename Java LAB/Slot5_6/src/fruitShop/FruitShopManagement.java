/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitShop;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class FruitShopManagement extends Fruit {
    private List<Fruit> listFruit = new ArrayList();
    private Hashtable<String, List<Fruit>> hashTable = new Hashtable<>();

    public FruitShopManagement() {
    }

    public void createProduct() {
        Scanner sc = new Scanner(System.in);
        String option;
        
        System.out.println("\nCREATE PRODUCT");
        do {
            System.out.print("\t- Fruit id: ");
            String id = sc.nextLine();
            System.out.print("\t- Fruit name: ");
            String name = sc.nextLine();
            System.out.print("\t- Price: ");
            double price = sc.nextDouble(); sc.nextLine();
            System.out.print("\t- Quantity: ");
            int quantity = sc.nextInt(); sc.nextLine();
            System.out.print("\t- Origin: ");
            String origin = sc.nextLine();
            
            Fruit f = new Fruit(id, name, price, quantity, origin);
            listFruit.add(f);

            System.out.print("Do you want to add more course(Y/N)? ");
                option = sc.nextLine();
        } while (option.toUpperCase().equals("Y"));

    }

    public void shopping() {
        Scanner sc = new Scanner(System.in);
        List<Fruit> listItemBought = new ArrayList<>();
        
        while (true) {
            System.out.println("List of Fruit:");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            for (Fruit f : listFruit) {
                System.out.printf("       %-13s%-18s%-15s%-10s", f.getIdFruit(), f.getNameFruit(), f.getOrigin(), f.getPrice());
            }
            
            System.out.print("Enter item you want order: ");
            int selected = sc.nextInt(); sc.nextLine();
            Fruit selecFruit = listFruit.get(selected - 1);
            System.out.println("You selected: " + selecFruit.getNameFruit());
            System.out.print("Please input quantity: ");
            int quantity = sc.nextInt(); sc.nextLine();
            selecFruit.setQuantity(quantity);
            listItemBought.add(selecFruit);
            
            System.out.print("Do you want to order now (Y/N)? ");
            String option = sc.nextLine();
            if (option.toUpperCase().equals("Y")) {
                System.out.println("Product | Quantity | Price | Amount ");
                double total = 0;
                for (Fruit f : listItemBought) {
                    System.out.println(f.getNameFruit() + "  " + quantity + "    " + f.getPrice() + "     " + (quantity * f.getPrice()));
                    total += quantity * f.getPrice();
                }
                System.out.println("Total: " + total);
                String nameCustomer = sc.nextLine();
                hashTable.put(nameCustomer, listItemBought);
                break;
            }
        }

    }

    public void viewOrders() {
        Enumeration<String> nameCustomerList = hashTable.keys();
        
        while (nameCustomerList.hasMoreElements()) {
            String nameCustomer = nameCustomerList.nextElement();
            System.out.println("Customer: " + nameCustomer);
            System.out.println("Product | Quantity | Price | Amount ");
            double total = 0;
            for (Fruit f : hashTable.get(nameCustomer)) {
                System.out.println(f.getNameFruit() + "  " + f.getQuantity() + "    " + f.getPrice() + "     " + (f.getQuantity() * f.getPrice()));
                total += f.getQuantity() * f.getPrice();
            }
            System.out.println("Total: " + total);
        }
    }
}
