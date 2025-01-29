package Rectangle;
import Shape.Shape;
public class Rectangle extends Shape{
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override 
    public int area()
    {
        return this.length * this.breadth;
    }

    @Override
    public int perimeter()
    {
        return 2*(this.length+this.breadth);
    }
}
