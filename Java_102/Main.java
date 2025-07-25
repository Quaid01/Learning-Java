package Java_102;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(new Point(1.8, -20), 2), 
                  new Square(new Point(100, 2.1), 5.4),
                  new Circle(new Point(0, 0), 1),
                  new Circle(new Point(4, 9.123), 98.32),
                  new Square(new Point(-321, 0), 0.02)};
        System.out.println(sumArea(shapes));
    }

    static double sumArea(Shape[] shapes) {
    double sum = 0;
    for (Shape shape : shapes) {
        sum += shape.area();
    }
    return sum;
}
}
