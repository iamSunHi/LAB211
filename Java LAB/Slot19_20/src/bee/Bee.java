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
abstract class Bee {
    protected double health;
    protected boolean dead;

    public Bee() {
        health = 100.0;
        dead = false;
    }

    public void Damage(int damagePercentage) {
        if (!dead) {
            double damage = (damagePercentage / 100.0) * health;
            health -= damage;
            if (health <= 0) {
                health = 0;
                dead = true;
            }
        }
    }

    public boolean IsDead() {
        return dead;
    }

    public double GetHealth() {
        return health;
    }

    public abstract String GetBeeType();
}
