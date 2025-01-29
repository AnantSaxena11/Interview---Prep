import java.util.*;
class Calculator{
    int  num1;
    int  num2;

    int add(int num1,int num2)
    {
        return num1+num2;
    }
    int difference(int num1,int num2)
    {
        return num1-num2;
    }
}
public class Index {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator cal = new Calculator();
        int num1,num2;
        System.out.println("Enter the first number and Second number");
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        System.out.println("Addition of two numbers is : "+cal.add(num1,num2));
        System.out.println("Difference of two numbers is : "+cal.difference(num1,num2));
        scan.close();
    }

}
