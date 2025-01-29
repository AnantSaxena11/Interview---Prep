package src.Humans;
import src.Singleton.index;
public class index {
    public static void main(String[] args)
    {
        Human Anant = new Human(21,"Anant",1000000,false);
        Human Rahul = new Human(21,"Rahul",1000,false);
        System.out.println("Population: "+Human.population);
        greeting();
        index single = new index();
        single.getInstance();
    }
// cannot access a non static inside a static method
    static void greeting(){
        System.out.println("Hello World!");
    }
    
} 
