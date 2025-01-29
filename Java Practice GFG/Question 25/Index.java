class Customer{
    private String name;
    private String address;
    private String number;

    public Customer(String name, String address, String number){
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void Display()
    {
        System.out.println("Name: "+name);
        System.out.println("Address: "+address);
        System.out.println("Number: "+number);
    }

    public double Discount(double price)
    {
        return price;
    }

};
class VipCustomer extends Customer{
    private double discount;

    public VipCustomer(String name,String address, String num,double discount)
    {
        super(name,address,num);
        this.discount = discount;
    }

    @Override
    public double Discount(double price)
    {
        return price - discount;
    }

    public void DisplayVIPDiscount()
    {
        System.out.println("Discount: "+discount);
    }
}

public class Index{
    public static void main(String[] args) {
        VipCustomer vip =  new VipCustomer("Anant", "D-165", "9971382117", 10);
        double discountedPrice = vip.Discount(1000);
        System.out.println("Discounted Price: "+discountedPrice);
        vip.Display();

    }
}