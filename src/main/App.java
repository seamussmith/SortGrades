package main;

class Student
{
    public String firstName;
    public String lastName;
    public int studentId;
    public double gpa;
    public String grade;
    public Student(String firstName, String lastName, int studentId, double gpa, String grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.gpa = gpa;
        this.grade = grade;
    }
}

public class App
{
    public static void main(String[] args) 
    {
        System.out.println("Hello, World!");
    }
}
