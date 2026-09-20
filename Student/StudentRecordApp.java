import java.util.Scanner;

public class StudentRecordApp{
    static int studentCount=0;
    static Student[] students= new Student[20];
    static Scanner input=new Scanner(System.in);

    public static void main(String[] args){
        
        boolean running = true;
        System.out.println("=================================================");
        System.out.println("Welcome to the student Record Keeping Application");
        while(running){
            showMenu();

            System.out.print("Enter Choice: ");
            int choice= input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    running=false;
                    break;
                default:
                    System.out.println("Invalid Input, try again!");

            }
            
        }
        input.close();
        
    }
    static void showMenu(){
        System.out.println("Select An Option");
        System.out.println("\t1. Add Student");
        System.out.println("\t2. View Students");
        System.out.println("\t3. Search Student");
        System.out.println("\t4. Update Student");
        System.out.println("\t5. Delete Student");
        System.out.println("\t6. Exit Program");
    };
    static void addStudent(){
        if(studentCount>= students.length){
            System.out.println(">>Student Record Full");
        }
        System.out.print("Enter Student Name: ");
        String name=input.nextLine();
        System.out.print("Enter Student Age: ");
        int age= input.nextInt();
        input.nextLine();
        System.out.print("Enter Student Matric Number: ");
        String matricNumber=input.nextLine();
        Student student=new Student(
            name,
            age,
            matricNumber
        );
        students[studentCount]=student;
        studentCount++;
        System.out.println(">>Student added sucessfully\n");
    };
    static void viewStudents(){
        if(studentCount==0){
            System.out.println(">>Student record is empty\n");
        }
        else{
            System.out.println("\n\n=======================================");
            System.out.println("===========Student Records=============");
            for(int i= 0; i<studentCount; i++){
            System.out.printf("Student %d Data\n", i+1);
            System.out.printf("  Name : %s \n  Age: %d \n  Matric Number: %s", students[i].name, students[i].age, students[i].MatricNumber);
            System.out.println();
        }
        }
        System.out.println("\t");
    };
    static void searchStudent(){
        System.out.print("Enter Matric Number: ");
        String MatricNumber=input.nextLine();
        if(studentCount==0){
            System.out.println(">>Student Record is empty. Add a Record.");
        }
        for(int i=0;i<studentCount;i++){
            if(students[i].MatricNumber.equals(MatricNumber)){
                System.out.println("\nStudent Found!");
                System.out.printf("  Name : %s \n  Age: %d \n  Matric Number: %s", students[i].name, students[i].age, students[i].MatricNumber);
                return;
            }
        }
        System.out.println(">>Student not found!");
    };
    static void updateStudent(){
        System.out.print("Enter Matric Number: ");
        String MatricNumber=input.nextLine();
        if(studentCount==0){
            System.out.println(">>Student Record is empty. Add a Record.");
        }
        for(int i=0;i<studentCount;i++){
            if(students[i].MatricNumber.equals(MatricNumber)){
                System.out.println("\nStudent Found!");
                System.out.print("Enter New Name: ");
                students[i].name = input.nextLine();
                System.out.print("Enter New Age: ");
                students[i].age = input.nextInt();
                input.nextLine();
                System.out.print("Enter New Matric Number: ");
                students[i].MatricNumber= input.nextLine();
                
                System.out.println(">>Record Updated successfully");
                System.out.printf("  Name : %s \n  Age: %d \n  Matric Number: %s", students[i].name, students[i].age, students[i].MatricNumber);
                return;
            }
        }
        System.out.println(">>Student not found!");
    };
    static void deleteStudent(){
        System.out.print("Enter Matric Number:");
        String MatricNumber=input.nextLine();
        if(studentCount==0){
            System.out.println(">>Student Record is empty. Add a Record.");
        }
        for(int i=0;i<studentCount;i++){
            if(students[i].MatricNumber.equals(MatricNumber)){
                for(int j=i; j<studentCount-1; j++){
                    students[j]=students[j+1];
                }
            students[studentCount-1]=null;
            studentCount--;
                System.out.println(">>Student deleted successfully");
                return;
            }

        }
        System.out.println(">>Student Not found!");
    };

}

class Student{
        String name;
        int age;
        String MatricNumber;
        public Student(String name, int age, String MatricNumber){
            this.name= name;
            this.age= age;
            this.MatricNumber= MatricNumber;
        }
    }