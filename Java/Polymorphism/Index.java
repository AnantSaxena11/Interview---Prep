package Polymorphism;

public class Index {
    void area()
    {
        System.out.println("I am in shapes");
    }
    public static void main(String[] args) {
        Index obj = new Index();
        obj.area();
        obj = new Rectangle();
        obj.area();
        obj = new Traingle();
        obj.area();
        obj = new Square();
        obj.area();
    }
    
}
