package javaExp;

public class exp2 {
      public static int area(int a){
        return a*a;
    }
    public static int area(int a,int b){
        return a*b;
    }
    public static void main(String[] args) {
        System.out.println("Area of square :" + area(5));
        System.out.println("Area of rectangle :" + area(5,6));
    }
}
