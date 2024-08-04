import java.util.Scanner;

class Student
{
    private int std_ID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department)
    {
        this.std_ID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID()
    {
        return std_ID;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getDepartment()
    {
        return department;
    }

    @Override
    public String toString() {
        return "Student ID: " + std_ID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentRecordSystem
{
    private Student[] students;
    private int cnt;

    public StudentRecordSystem(int c)
    {
        students = new Student[c];
        cnt = 0;
    }

    public void addStudent(Student s)
    {
        if (cnt < students.length)
        {
            students[cnt] = s;
            cnt++;
            System.out.println("Student added successfully.");
        }
        else
        {
            System.out.println(" Cannot add more students. The system is at full capacity.");
        }
    }

    public Student getStudent(int std_ID)
    {
        for (int i = 0; i < cnt; i++)
        {
            if (students[i].getStudentID() == std_ID)
            {
                return students[i];
            }
        }
        return null;
    }

    public void displayAllStudents()
    {
        if (cnt == 0)
        {
            System.out.println("No student records available.");
        }
        else
        {
            for (int i = 0; i < cnt; i++)
            {
                System.out.println(students[i]);
            }
        }
    }
}


class StudentRecordMGMT
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int capacity = 20;
        StudentRecordSystem recordSystem = new StudentRecordSystem(capacity);

        while (true)
        {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student Record ");
            System.out.println("2. View Student Record by ID ");
            System.out.println("3. Display All Student Records ");
            System.out.println("4. Exit ");
            System.out.print("Choose an option : ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:

                    System.out.print("Enter Student ID : ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Department : ");
                    String department = scanner.nextLine();

                    Student student = new Student(studentId, name, age, department);
                    recordSystem.addStudent(student);
                    break;

                case 2:

                    System.out.print("Enter Student ID : ");
                    studentId = scanner.nextInt();

                    Student foundStudent = recordSystem.getStudent(studentId);
                    if (foundStudent != null)
                    {
                        System.out.println("Student Record : " + foundStudent);
                    }
                    else
                    {
                        System.out.println("Student with ID " + studentId + " not found.");
                    }
                    break;

                case 3:

                    System.out.println("All Student Records :");
                    recordSystem.displayAllStudents();
                    break;

                case 4:

                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}