abstract public class A{
    int num;
    String name;
    public A(int num, String name){
        this.num = num;
        this.name = name;
    }
    protected abstract void print();
}