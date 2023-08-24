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
public class SuperlativeEquation {
    private double a;
    private double b;

    public SuperlativeEquation() {
    }

    public SuperlativeEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public List<Double> calculateSuperlativeEquation(double a, double b) {
        List<Double> result = new ArrayList<>();
        
        if (a == 0 && b == 0)
            return result;
        else if (a == 0) {
            return null;
        }
        else {
            double x = -b / a;
            result.add(x);
        }
        
        return result;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
