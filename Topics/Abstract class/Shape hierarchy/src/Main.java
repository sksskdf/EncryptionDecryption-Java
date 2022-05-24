import java.util.Arrays;
import java.util.stream.DoubleStream;

abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double[] sides;

    public Triangle(double first, double second, double third) {
        sides = DoubleStream.of(first, second, third).toArray();
    }

    @Override
    double getPerimeter() {
        return Arrays.stream(sides).sum();
    }

    @Override
    double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
}

class Rectangle extends Shape {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    double getArea() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}