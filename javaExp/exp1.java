package javaExp;

class Student{
    private String name;
    private String UID;
    private int age;
    Student(String name,String UID,int age){
        this.name = name;
        this.UID = UID;
        this.age  = age;
    }
    public void displayDetails(){
        System.out.println("Name " + this.name + "\nUID " + this.UID + "\nAge " + this.age);
    }
}
public class exp1 {
    public static void main(String[] args) {
        Student s1 = new Student("Ram" , "24BCS12731",20);
        s1.displayDetails();
    }
}
