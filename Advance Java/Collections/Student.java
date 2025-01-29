package Collections;

import java.util.Objects;

public class Student{
    int rollno;
    String name;
    Student(int rollno, String name){
        this.rollno = rollno;
        this.name = name;
    }
    @Override
    public String toString(){
        return rollno + " " + name;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        Student s = (Student) obj;
        return s.rollno == this.rollno;
    }
    @Override
    public int hashCode(){
        return Objects.hash(rollno);
    }
}