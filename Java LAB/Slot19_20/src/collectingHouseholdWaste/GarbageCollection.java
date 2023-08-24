/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectingHouseholdWaste;

/**
 *
 * @author Nhật Huy
 */
public class GarbageCollection {
    private final int MAX_CAPACITY = 10000;
    private final int LOADING_TIME = 8;
    private final int DUMP_TIME = 30;
    private final int LABOR_COST = 120000;
    private final int DUMP_COST = 57000;

    private GarbageStation[] stations;

    public GarbageCollection(GarbageStation[] stations) {
        this.stations = stations;
    }

    public int calculateCost() {
        int totalCost = 0;
        int totalGarbage = 0;
        int time = 0;

        for (int i = 0; i < stations.length; i++) {
            totalGarbage += stations[i].getGarbageAmount();
            time += LOADING_TIME;

            if (totalGarbage >= MAX_CAPACITY) {
                totalCost += time * LABOR_COST;
                totalCost += DUMP_COST;
                totalGarbage = 0;
                time += DUMP_TIME;
            }

            if (i == stations.length - 1) {
                time += DUMP_TIME;
            }
        }

        return totalCost;
    }
}
