package Java_102;

public class Circle implements Shape{
    public final Point center;
    public final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /** 
    * @return Whether point p is inside of the circle.
    */
    public boolean isInside(Point p) {
        return Point.distance(center, p) < radius;
    }

    /** 
    * @return Whether point p part of/on the border of the circle.
    */
    public boolean isOn(Point p) {
        return Point.distance(center, p) == radius;
    }

    /** 
    * @param x How much to translate the circle by in the + x direction.
    * @param y How much to translate the circle by in the + y direction.
    * @return The circle that results from the translation.
    */
    public Circle translate(double x, double y) {
        return new Circle(center.translateX(x).translateY(y), radius);
    }

    /** 
    * @return The circle that results from scaling by k.
    */
    public Circle scale(double k) {
        return new Circle(center, radius * k);
    }

    @Override
    public String toString() {
        return "(center: " + center + "; radius: " + radius + ")";
    }

    public static Circle fromPoints(Point p1, Point p2, Point p3) {
        Point p1_p2_mid = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        Point p2_p3_mid = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
        double p1_p2_slope = (p2.y - p1.y) / (p2.x - p1.x);
        double p2_p3_slope = (p3.y - p2.y) / (p3.x - p2.x);
        double perp_p1_p2_slope = -1 / p1_p2_slope;
        double perp_p2_p3_slope = -1 / p2_p3_slope;

        double b1 = p1_p2_mid.y - perp_p1_p2_slope * p1_p2_mid.x;
        double b2 = p2_p3_mid.y - perp_p2_p3_slope * p2_p3_mid.x;

        double cx = (b2 - b1) / (perp_p1_p2_slope - perp_p2_p3_slope);
        double cy = perp_p1_p2_slope * cx + b1;

        Point center = new Point(cx, cy);
        double radius = Math.hypot(center.x - p1.x, center.y - p1.y);

        return new Circle(center, radius);
    }
}