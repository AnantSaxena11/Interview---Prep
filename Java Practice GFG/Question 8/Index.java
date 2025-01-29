class Student{
    private String name;
    private int age;
    private double marks;
    private char grade;

    public Student(String name, int age, double marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = ' ';
        calculateGrade();
    }

    private void calculateGrade()
    {
        if(marks >= 90)
            this.grade = 'A';
        else if(marks >= 80)
            this.grade = 'B';
        else if(marks >= 70)
            this.grade = 'C';
        else if(marks >= 60)
            this.grade = 'D';
        else
            this.grade = 'F';
    }

    public void Display()
    {

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
};

public class Index {
    public static void main(String[] args) {
        Student s1 = new Student("John", 20, 95);
        s1.Display();
    }
}
