package Collections;
import java.util.*;
public class PracticeHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> mp = new HashMap<>();
        mp.put("Anant",20);
        mp.put("Ayushi",40);
        mp.put("Madhuri",50);
        System.out.println(mp);
        Iterator<Map.Entry<String,Integer>> itr = mp.entrySet().iterator();
        for(;itr.hasNext();)
        {
            Map.Entry<String,Integer> entry = itr.next();
            System.out.println(entry.getKey() + entry.getValue());
        }
        for(String key : mp.keySet())
        {
            System.out.println(key);
        }
        for(Integer value : mp.values())
        {
            System.out.println(value);
        }

        Iterator<Map.Entry<String,Integer>> itrr = mp.entrySet().iterator();

        for(;itr.hasNext();)
        {
            Map.Entry<String,Integer> entry = itr.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

        for(String key : mp.keySet())
        {
            System.out.println(key);
        }

        for(Integer value : mp.values())
        
        {
            System.out.println(value);
        }
        if(mp.containsValue(30))
        {
            System.out.println("yes");
        }
    }
}
