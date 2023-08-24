/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bee;

/**
 *
 * @author Nhật Huy
 */
public class DroneBee extends Bee {
    @Override
    public boolean IsDead() {
        return dead || health < 50;
    }

    @Override
    public String GetBeeType() {
        return "Drone";
    }
}
