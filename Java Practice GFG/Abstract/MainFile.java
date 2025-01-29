import Circle.*;
import Rectangle.Rectangle;
public class MainFile
{
    public static void main(String args[])
    {
        Circle c = new Circle(5);
        Rectangle r = new Rectangle(5, 10);
        System.out.println("Area of Circle: "+c.area());
        System.out.println("Perimeter of Circle: "+c.perimeter());
        System.out.println("Area of Rectangle: "+r.area());
        System.out.println("Perimeter of Rectangle: "+r.perimeter());
    }
}