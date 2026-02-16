import java.util.Scanner;
import java.util.InputMismatchException;

class Student{
    String name;
    int averageMarks;
    char grade;
    @Override
    public String toString() {
        return "Student Name : " + this.name +
               "\nMarks Entered (Average) : " + this.averageMarks +
               "\nGrade Obtained : " + this.grade;
    }
}
class Main{
    public static void main(String[] args) {
        try{
            Student s = new Student();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name of the student : ");
            String name  = sc.nextLine();
            int totalMarks = 0;
            System.out.println("Enter marks for 5 subjects (each out of 100): ");
            for(int i = 1; i <= 5; i++){
                int marks = sc.nextInt();
                if(marks < 0 || marks > 100){
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
                totalMarks += marks;
            }

            int average = totalMarks / 5;
            s.name = name;
            s.averageMarks =average;
            if(average >= 90){
                s.grade = 'A';
            }
            else if(average >= 75){
                s.grade = 'B';
            }
            else if(average >= 60){
                s.grade = 'C';
            }
            else if(average >= 40){
                s.grade = 'D';
            }
            else{
                s.grade = 'F';
            }

            System.out.println(s);
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter numeric marks only.");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Marks evaluation completed.");
        }
    }
}
