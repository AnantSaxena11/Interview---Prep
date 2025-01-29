class ObjectCreation{
    private static int count;
    ObjectCreation(){
        count++;
    }
    static int getCount(){
        return count;
    }
}
public class Index {
    public static void main(String[] args) {
        ObjectCreation obj1 = new ObjectCreation();
        ObjectCreation obj2 = new ObjectCreation();
        ObjectCreation obj3 = new ObjectCreation();
        System.out.println(ObjectCreation.getCount());
    }
        
}
