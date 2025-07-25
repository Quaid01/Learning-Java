package Java_102;

public class Square implements Shape{
    public final Point corner;
    public final double sideLength;

    /**
    * @param corner The bottom left corner of the square
    * @param sideLength
    */
    public Square(Point corner, double sideLength) {
        this.corner = corner;
        this.sideLength = sideLength;
    }

    public double area() {
        return Math.pow(sideLength, 2);
    }

    public double perimeter() {
        return 4*sideLength;
    }

    /** 
    * @return Whether point p is inside of the square.
    */
    public boolean isInside(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return 0 < xDist && xDist < sideLength &&
               0 < yDist && yDist < sideLength;
    }

    /** 
    * @return Whether point p part of/on the border of the square.
    */
    public boolean isOn(Point p) {
        boolean on = false;
        // checks for top and bottom sides
        if (corner.x < p.x && p.x < corner.x+sideLength && (p.y == corner.y || p.y == corner.y+sideLength)) {
            on = true;
        }
        // checks for left and right
        if (corner.y < p.y && p.y < corner.y+sideLength && (p.x == corner.x || p.x == corner.x+sideLength)) {
            on = true;
        }
        return on;
    }

    /** 
    * @param x How much to translate the sqaure by in the + x direction.
    * @param y How much to translate the squarer by in the + y direction.
    * @return The sqaure that results from the translation.
    */
    public Square translate(double x, double y) {
        double newX = corner.x + x;
        double newY = corner.y + y;
        return new Square(new Point(newX, newY), sideLength)
    }

    /** 
    * @return The sqaure that results from scaling the side length and maintaining the bottom left corner
    */
    public Square scale(double k) {
        return new Square(corner, sideLength * k);
    }

    public Point[] corners() {
        Point[] points = new Point[4];
        points[0] = new Point(corner.x, corner.y);
        points[1] = new Point(corner.x + sideLength, corner.y);
        points[2] = new Point(corner.x, corner.y+sideLength);
        points[3] = new Point(corner.x +sideLength, corner.y +sideLength);

        return points;
    }

    @Override
    public String toString() {
        return "(corner: " + corner + "; side length: " + sideLength + ")";
    }
}