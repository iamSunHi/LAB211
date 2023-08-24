/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectingHouseholdWaste;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class GarbageCollectionCost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount of garbage at each station (in kg): ");
        String input = sc.nextLine();
        String[] amounts = input.split(" ");

        GarbageStation[] stations = new GarbageStation[amounts.length];
        for (int i = 0; i < amounts.length; i++) {
            int garbageAmount = Integer.parseInt(amounts[i]);
            stations[i] = new GarbageStation(garbageAmount);
        }

        GarbageCollection collection = new GarbageCollection(stations);
        int totalCost = collection.calculateCost();
        System.out.println("The total cost is " + totalCost + " VND");
    }
}
