// import java.util.*;
class Student{
    int roll;
    String name;
    public Student()
    {
        this( 5, "Anant");
    }
    Student(int roll, String name)
    {
        this.roll = roll;
        this.name = name;
    }

};
class Wrapper {
    int value;
    Wrapper(int value) {
        this.value = value;
    }
}

public class Hello {
    static void swap(Wrapper a, Wrapper b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {
        Wrapper a = new Wrapper(10);
        Wrapper b = new Wrapper(20);
        swap(a, b);
        System.out.println(a.value + " " + b.value); // Output: 20 10
    }
}
