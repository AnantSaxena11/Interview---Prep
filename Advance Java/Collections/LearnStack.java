package Collections;

import java.util.*;

public class LearnStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        stack.pop();
        System.out.println(stack);
        stack.peek();
        stack.empty();
        stack.pop();
        System.out.println(stack.search(10));
    }
   

    
}
