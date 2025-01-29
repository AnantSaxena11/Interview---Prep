package Collections;
import java.util.*;
public class LearnHashSet {
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();
        Student s1 = new Student(1, "A");
        Student s2 = new Student(2, "B");
        Student s3 = new Student(3, "C");
        Student s4 = new Student(4, "D");
        Student s5 = new Student(4, "D");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        System.out.println(set);


    }
}
