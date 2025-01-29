package Circle;
import Shape.Shape;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int area() {
        return (int) (Math.PI * Math.pow(this.radius, 2));
    }

    @Override

    public int perimeter()
    {
        return (int) (2 * Math.PI * this.radius);

    }
}