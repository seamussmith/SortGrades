package main;

import java.util.Comparator;

record Student(String firstName, String lastName, int studentId, double gpa, String grade)
{
    public static final Comparator<Student> byFirstName = (Student a, Student b) -> a.firstName().compareTo(a.firstName());
    public static final Comparator<Student> byLastName = (Student a, Student b) -> a.lastName().compareTo(a.lastName());
    public static final Comparator<Student> byStudentId = (Student a, Student b) -> a.studentId() - b.studentId();
    public static final Comparator<Student> byGpa = (Student a, Student b) -> {
        if (a.gpa() > b.gpa())
            return 1;
        else if (a.gpa() == b.gpa())
            return 0;
        return -1;
    };
    public static final Comparator<Student> byGrade = (Student a, Student b) -> a.grade().compareTo(a.grade());
}
public class App
{
    public static void main(String[] args) 
    {
        var x = new Student("Jared", "Castro", 195785478, 4.0, "A");
        System.out.println("Hello, World!");
    }
}
