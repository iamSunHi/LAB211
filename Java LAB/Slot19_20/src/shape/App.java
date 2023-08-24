/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author Nhật Huy
 */
public class App {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Sphere(2);
        shapes[3] = new Cube(3);

        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.toString());
            if (shape instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeDShape = (ThreeDimensionalShape) shape;
                System.out.println("Surface Area: " + shape.getArea());
                System.out.println("Volume: " + threeDShape.getVolume());
            } else {
                System.out.println("Area: " + shape.getArea());
            }
            System.out.println();
        }
    }
}
