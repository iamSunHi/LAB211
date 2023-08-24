/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====Calculator Shape Program=====");
        System.out.println("Please input side width of Rectangle:");
        double width = sc.nextDouble();
        System.out.println("Please input length of Rectangle:");
        double length = sc.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("Please input radius of Circle:");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);

        System.out.println("Please input side A of Triangle:");
        double sideA = sc.nextDouble();
        System.out.println("Please input side B of Triangle:");
        double sideB = sc.nextDouble();
        System.out.println("Please input side C of Triangle:");
        double sideC = sc.nextDouble();
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
