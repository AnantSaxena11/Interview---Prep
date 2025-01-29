class Employee{
    private int EmpId;
    private String name;
    private String Department;
    public Employee(int EmpId,String name)
    {
        this.name = name;
        this.EmpId = EmpId;
    }

    public Employee(int EmpId,String name,String Department)
    {
        this.name = name;
        this.EmpId = EmpId;
        this.Department = Department;
    }

    public void Display()
    {
        System.out.println("Employee ID : "+this.EmpId);
        System.out.println("Employee Name : "+this.name);
        System.out.println("Employee Department : "+this.Department);
    }
}
public class Index {
    public static void main(String[] args) {

        Employee emp1 = new Employee(10,"Anant");
        Employee emp2 = new Employee(20,"Anant","IT");
        emp1.Display();
        emp2.Display();
        
    }
}
