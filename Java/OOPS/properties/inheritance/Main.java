package OOPS.properties.inheritance;

public class Main {
    public static void main(String[] args) {
        // Box box1 = new Box();
        // System.out.println(box1.l + " " + box1.w + " " + box1.h);
        // Box box2 = new Box(10);
        // System.out.println(box2.l + " " + box2.w + " " + box2.h);
        // Box box3 = new Box(10,12,13);
        // System.out.println(box3.l + " " + box3.w + " " + box3.h);
        BoxWeight boxWeight1 = new BoxWeight(10,10,10,10);
        System.out.println(boxWeight1.l + " " + boxWeight1.w + " " + boxWeight1.h + " " + boxWeight1.weight);
    }
}
