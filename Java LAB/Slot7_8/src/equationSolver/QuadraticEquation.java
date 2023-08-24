/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equationSolver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhật Huy
 */
public class QuadraticEquation extends SuperlativeEquation {

    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        super(a, b);
        this.c = c;
    }

    public List<Double> calculateQuadraticEquation() {
        List<Double> result = new ArrayList<>();

        if (this.getA() == 0 && this.getB() == 0 && this.getC() == 0) {
            return result;
        } else if (this.getA() == 0) {
            result = this.calculateSuperlativeEquation(this.getB(), this.getC());
        } else {
            double discriminant = Math.pow(super.getB(), 2) - 4 * super.getA() * this.c;
            if (discriminant < 0) {
                return null;
            } else if (discriminant == 0) {
                double x = -this.getB() / (2 * this.getA());
                result.add(x);
                result.add(x);
            } else {
                double x1 = (-this.getB() + Math.sqrt(discriminant)) / (2 * this.getA());
                double x2 = (-this.getB() - Math.sqrt(discriminant)) / (2 * this.getA());
                result.add(x1);
                result.add(x2);
            }
        }

        return result;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
