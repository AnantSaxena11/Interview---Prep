package Collections;
import java.util.*;

public class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        // peek search poll remove size element return the head of the queue dont use add 
        System.out.println(queue.element());

    }
}
