package Collections;
import java.util.*;
public class LearnHashMaps {
    public static void main(String[] args) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(10,20);
        mp.put(20, 30);
        System.out.println(mp);
        Iterator<Map.Entry<Integer,Integer>> itr = mp.entrySet().iterator();
        for(itr = mp.entrySet().iterator();itr.hasNext();)
        {
            Map.Entry<Integer,Integer> entry = itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Iterator<Map.Entry<Integer,Integer>> itrr = mp.entrySet().iterator();

        Iterator<Mpa.Entry<Integer,Integer>> itrrr = mp.entrySet().iterator();

        Iterator<Map.Entry<Integer,Integer>> itrrrrr = mp.entrySet().iterator();
        

    }
}
