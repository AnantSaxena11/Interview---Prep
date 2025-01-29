package Collections;
import java.util.*;
public class LearnPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap first the minimum element will come
        pq.offer(10);
        pq.offer(20);
        pq.offer(30);
        System.out.println(pq.remove());
        pq.poll();
        System.out.println(pq);
    }
}
