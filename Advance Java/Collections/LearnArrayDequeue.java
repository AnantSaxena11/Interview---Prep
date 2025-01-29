package Collections;

import java.util.*;

public class LearnArrayDequeue {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offerFirst(10 );
        adq.offerLast(55);
        System.out.println(adq);
        // can use all the functionof queue like
        // add or offer this most preferred
        // remove or poll this most preferred
        // peek
        // size
        // element
    }

}
