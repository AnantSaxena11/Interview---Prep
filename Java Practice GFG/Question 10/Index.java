class lastDigit{
    private int number;
    public lastDigit(int number)
    {
        this.number = number;
    }
    public int getlargestNumber()
    {
        return number%10;
    }
}
public class Index {
    public static void main(String[] args) {
        lastDigit lastDigit = new lastDigit(123);
        System.out.println(lastDigit.getlargestNumber());
    }
}
