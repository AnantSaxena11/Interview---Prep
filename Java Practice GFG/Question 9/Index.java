class LargestNumber{

    public int getlargestNumber(int num1,int num2,int num3)
    {
        return Math.max(Math.max(num1,num2),num3);
    }

    public double getlargestNumber(double num1,double num2,double num3)
    {
        return Math.max(Math.max(num1,num2),num3);
    }

};
public class Index {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.getlargestNumber(10,20,30));
        System.out.println(largestNumber.getlargestNumber(10.5,20.5,30.5));   
    }
}
