package Java_102;

public class Point {

    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point translateX(double t) {
        return new Point(x + t, y);
    }

    public Point translateY(double t) {
        return new Point(x, y + t);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static Point centerOfMass(Point[] points) {
        double sumX = 0;
        double sumY = 0;
        for (Point point : points) {
            sumX += point.x;
            sumY += point.y;
        }
        double comX = sumX/points.length;
        double comY = sumY/points.length;
        return new Point(comX, comY);
    }

    public double angle() {
        double base_angle = Math.atan(this.y/this.x);
        double result = 0;
        if (this.x>=0) {
            result = Math.toDegrees(base_angle);
        }
        if (this.x<0) {
            result = Math.toDegrees(base_angle + Math.PI);
        }
        return result;
    } 

    public Point rotate(double theta) {
        double newX = x*Math.cos(theta) + x*Math.sin(theta);
        double newY = -x*Math.sin(theta) + x*Math.cos(theta);
        return new Point(newX, newY);
    }

}
