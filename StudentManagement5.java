import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Student
{
    private String name;
    private String rollNumber;
    private String grade;
    public Student(String name, String rollNumber, String grade)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public String getName()
    {
        return name;
    }

    public String getRollNumber()
    {
        return rollNumber;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) 
    {
        this.rollNumber = rollNumber;
    }

    public void setGrade(String grade) 
    {
        this.grade = grade;
    }
    public void displayStudent() 
    {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}
public class StudentManagement5 {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        StudentManagement5 sms = new StudentManagement5();
        sms.run();
    }
    public void run() 
    {
        while (true) 
        {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void addStudent() 
    {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (validateInput(name, rollNumber, grade)) 
        {
            students.add(new Student(name, rollNumber, grade));
            System.out.println("Student added successfully.");
        } 
        else 
        {
            System.out.println("Invalid input. Please try again.");
        }
    }
    private void removeStudent() 
    {
        System.out.print("Enter roll number of student to remove: ");
        String rollNumber = scanner.nextLine();
        Iterator<Student> iterator = students.iterator();
        boolean found = false;

        while (iterator.hasNext()) 
        {
            Student student = iterator.next();
            if (student.getRollNumber().equals(rollNumber)) 
            {
                iterator.remove();
                System.out.println("Student removed successfully.");
                found = true;
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
    private void searchStudent() 
    {
        System.out.print("Enter roll number of student to search: ");
        String rollNumber = scanner.nextLine();
        boolean found = false;

        for (Student student : students) 
        {
            if (student.getRollNumber().equals(rollNumber)) 
            {
                student.displayStudent();
                found = true;
                break;
            }
        }

        if (!found) 
        {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
    private void displayAllStudents() 
    {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } 
        else 
        {
            for (Student student : students) 
            {
                student.displayStudent();
                System.out.println("---------------------");
            }
        }
    }
    private boolean validateInput(String name, String rollNumber, String grade) 
    {
        return !name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty();
    }
}



/*
 Output:-
 Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 1
Enter name: OM
Enter roll number: 1
Enter grade: A
Student added successfully.

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 1
Enter name: 2
Enter roll number: RUSHI
Enter grade: BB
Student added successfully.

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 4
Name: OM
Roll Number: 1
Grade: A
---------------------
Name: 2
Roll Number: RUSHI
Grade: BB
---------------------

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 3
Enter roll number of student to search: 1
Name: OM
Roll Number: 1
Grade: A

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 2
Enter roll number of student to remove: 2
Student with roll number 2 not found.

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 4
Name: OM
Roll Number: 1
Grade: A
---------------------
Name: 2
Roll Number: RUSHI
Grade: BB
---------------------

Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option:
 */