/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerProgram;

/**
 *
 * @author Nhật Huy
 */
public class BMI {

    private double weight;
    private double height;

    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double calculateBMI() {
        double heightInMeter = height / 100;
        return weight / (heightInMeter * heightInMeter);
    }

    public String getBMIStatus() {
        double bmi = calculateBMI();
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi >= 19 && bmi <= 25) {
            return "Standard";
        } else if (bmi > 25 && bmi <= 30) {
            return "Overweight";
        } else if (bmi > 30 && bmi <= 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
