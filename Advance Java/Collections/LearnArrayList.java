package Collections;
import java.util.*;

class LearnArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); 
        System.out.println(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        list2.add(2,300);
        list.addAll(list2);
        list.set(2,400);
        System.out.println(list.contains(50));
        System.out.println(list);
        for(int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        Iterator<Integer> it = list.iterator();
        for(it = list.iterator();it.hasNext();)
        {
            System.out.println(it.next());
        }
        list.remove(0);
        list.remove(Integer.valueOf(100));
        System.out.println(list);
        list.clear();
        System.out.println(list.size());

    }
}
