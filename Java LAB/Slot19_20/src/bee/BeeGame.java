/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nhật Huy
 */
public class BeeGame {

    private List<Bee> beeList;

    public BeeGame() {
        this.beeList = new ArrayList<>();
    }

    public void createBeeList() {
        for (int i = 0; i < 10; i++) {
            beeList.add(new WorkerBee());
            beeList.add(new QueenBee());
            beeList.add(new DroneBee());
        }
    }

    public void attackBees() {
        Random random = new Random();
        beeList.forEach((bee) -> {
            int damagePercentage = random.nextInt(81); // Random value between 0 and 80
            bee.Damage(damagePercentage);
        });
    }

    public void printBeeStatus() {
        System.out.println("Bee Status:");
        System.out.println("+------+--------+--------+---------+");
        System.out.println("| Bee  |  Type  | Status |  Health |");
        System.out.println("+------+--------+--------+---------+");

        for (int i = 0; i < beeList.size(); i++) {
            Bee bee = beeList.get(i);
            String beeType = bee.GetBeeType();
            String status = bee.IsDead() ? "Dead" : "Alive";
            double health = bee.GetHealth();
            System.out.printf("| %4d | %6s | %6s | %7.2f |\n", i + 1, beeType, status, health);
        }

        System.out.println("+------+--------+--------+---------+");
    }
}
