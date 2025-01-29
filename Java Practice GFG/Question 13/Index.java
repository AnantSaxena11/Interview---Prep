class Car {
    private String make;
    private String model;
    private String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public void display()
    {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
};

public class Index {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", "2018");
        car.display();
    }
}
