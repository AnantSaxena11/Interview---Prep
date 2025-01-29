class Student {
    private String name;
    private int math;
    private int physics;
    private int chemistry;
    public Student(String name, int math, int physics, int chemistry) {
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }
    public int totalAvg() {
        return (math + physics + chemistry)/3;
    }
    public int total()
    {
        return math + physics + chemistry;
    }
}

public class Index {
    public static void main(String[] args) {
        Student student = new Student("John", 90, 80, 70);
        System.out.println("Total marks: " + student.total());
        System.out.println("Average marks: " + student.totalAvg());
    }
}
