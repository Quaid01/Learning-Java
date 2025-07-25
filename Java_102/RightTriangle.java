package Java_102;

public class RightTriangle implements Shape{
    public final Point corner_intersection;
    public final double leg_x;
    public final double leg_y;   

    public RightTriangle(Point corner_intersection,double leg_x, double leg_y){
        this.corner_intersection = corner_intersection;
        this.leg_x = leg_x;
        this.leg_y = leg_y;
    }

    public double area() {
        return leg_x*leg_y/2;
    }

    public double perimeter() {
        return leg_x + leg_y + hypotenuse();
    }

    public double hypotenuse() {
        return Math.sqrt(Math.pow(leg_x, 2) + Math.pow(leg_y, 2));
    }

    public Shape translate(double x, double y) {
        return new RightTriangle(new Point(corner_intersection.x + x, corner_intersection.y + y), leg_x, leg_y);
    }

    public Shape scale(double k) {
        return new RightTriangle(corner_intersection, leg_x *k, leg_y*k);
    }

    @Override
    public String toString() {
        return "(corner: " + corner_intersection + "; leg in x direction: " + leg_x + "; leg in y direction: " + leg_y + ")";
    }

    public boolean isOn(Point p) {
        boolean on = false;
        // handles leg parallel to x
        if (corner_intersection.x <= p.x && p.x <= corner_intersection.x + leg_x && p.y == corner_intersection.y) {
            on =true;
        }
        // handles leg parallel to y
        if (corner_intersection.y <= p.y && p.y <= corner_intersection.y + leg_y && p.x == corner_intersection.x) {
            on =true;
        }
        double slope_h = leg_y/leg_x;
        if (p.y == slope_h *p.x +corner_intersection.y) {
            on = true;
        }
        return on;
    }

    public boolean isInside(Point p) {
        boolean in = false;
        double slope_h = leg_y/leg_x;
        if (corner_intersection.x < p.x && p.x < corner_intersection.x + leg_x && corner_intersection.y  < p.y && p.y < slope_h *p.x +corner_intersection.y) {
            in = true;
        }
        return in;
    }

    public static boolean similar(RightTriangle a, RightTriangle b) {
        return (a.leg_x/b.leg_x == a.leg_y/b.leg_y);
    }

}
