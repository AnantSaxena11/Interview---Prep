class Person{
    private String firstname;
    private String lastname;
    public Person(String firstname,String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    @Override
    public String toString()
    {
        return "Person [firstname=" + firstname + ", lastname=" + lastname + "]";
    }
}
public class Index {
    public static void main(String[] args) {
        Person p = new Person("Anant","Saxena");
        System.out.println(p.toString());
    }    
}
