package src.Humans;

public class staticExample {
    static int a = 4;
    static int b = 6;

    static {  // this only runs once when the first object is created 
        b = a*5;
    }
    public static void main(String[] args) {
        staticExample obj = new staticExample();
        System.out.println("Value of a: "+staticExample.a + " Value of b: "+staticExample.b);

        staticExample.b +=3;
        staticExample obj2 = new staticExample();
        System.out.println("Value of a: "+staticExample.a + " Value of b: "+staticExample.b);
    }
}
