package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

record Student(String firstName, String lastName, int studentId, double gradePerc, String grade)
{
    public static final Comparator<Student> byFirstName = (Student a, Student b) -> a.firstName().compareTo(b.firstName());
    public static final Comparator<Student> byLastName = (Student a, Student b) -> a.lastName().compareTo(b.lastName());
    public static final Comparator<Student> byStudentId = (Student a, Student b) -> a.studentId() - b.studentId();
    public static final Comparator<Student> byGpa = (Student a, Student b) -> {
        if (a.gradePerc() > b.gradePerc())
            return 1;
        else if (a.gradePerc() == b.gradePerc())
            return 0;
        return -1;
    };
    public static final Comparator<Student> byGrade = (Student a, Student b) -> a.grade().compareTo(b.grade());
}
public class App
{
    public static void main(String[] args) 
    {
        var scan = new Scanner(System.in);
        var students = new ArrayList<Student>();
        while (scan.hasNextLine())
        {
            var ln = scan.nextLine();
            var split = ln.split("\\s");
            students.add(new Student(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]), split[4]));
        }

        Comparator<Student> sorter;
        if (args.length < 1 || args[0].equals("firstName"))
            sorter = Student.byFirstName;
        else if (args[0].equals("lastName"))
            sorter = Student.byLastName;
        else if (args[0].equals("studentId"))
            sorter = Student.byStudentId;
        else if (args[0].equals("gpa"))
            sorter = Student.byGpa;
        else if (args[0].equals("grade"))
            sorter = Student.byGrade;
        else
            sorter = Student.byFirstName;
        
        students.sort(sorter);

        for (var s : students)
            System.out.println(s);

        scan.close();
    }
}
