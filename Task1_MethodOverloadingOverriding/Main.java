// Lab Task 1: Method Overloading and Method Overriding
// Demonstrates:
//   - Method overloading: multiple area() methods in Shape with different
//     parameter lists (no-arg, one parameter, two parameters).
//   - Method overriding: Rectangle redefines the no-arg area() method
//     inherited from Shape.

class Shape {

    // No-arg version: displays a general message.
    void area() {
        System.out.println("Area of Shape");
    }

    // Overloaded: area of a square (one parameter).
    double area(double side) {
        return side * side;
    }

    // Overloaded: area of a rectangle (two parameters).
    double area(double length, double width) {
        return length * width;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Overridden: Rectangle's own version of the no-arg area() method.
    @Override
    void area() {
        System.out.println("Area of Rectangle = " + (length * width));
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Rectangle rectangle = new Rectangle(6, 4);

        System.out.println("--- Method Overloading (Shape) ---");
        shape.area();                                   // no-arg version
        System.out.println("Area of Square (side 5) = " + shape.area(5));
        System.out.println("Area of Rectangle (4 x 6) = " + shape.area(4, 6));

        System.out.println("\n--- Method Overriding (Rectangle) ---");
        rectangle.area();                               // overridden version

        System.out.println("\n--- Overloaded method inherited by Rectangle ---");
        System.out.println("Area of Square (side 3) = " + rectangle.area(3));

        System.out.println("\n--- Parent reference, child object ---");
        Shape shapeRef = rectangle;                     // upcasting
        shapeRef.area();                                // calls Rectangle's area()
    }
}
