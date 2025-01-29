class Pair{
    private int x;
    private int y;
    public Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void display()
    {
        System.out.println("X : "+this.x);
        System.out.println("Y : "+this.y);
    }
};
class Rectangle{
    private int length;
    private int breadth;
    Rectangle()
    {
        this.length = 1;
        this.breadth = 1;
    }
    public void SetAttribute(int length,int breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }
    public void Display()
    {
        System.out.println("Length : "+this.length);
        System.out.println("Breadth : "+this.breadth);
    }
    public int Calculatearea()
    {
        return this.length * this.breadth;
    }
};
public class Index {
  public static void main(String[] args) {
    Pair p = new Pair(10,20);
    p.display();
    Rectangle r = new Rectangle();
    r.SetAttribute(10,20);
    r.Display();
    System.out.println("Area of the rectangle is : "+r.Calculatearea());
  }  
};
