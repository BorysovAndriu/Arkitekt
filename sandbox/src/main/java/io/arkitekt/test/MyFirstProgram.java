package io.arkitekt.test;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("World");
    hello("User");

    System.out.println("Площа квадрата = " + area(6));

    System.out.println("Площа прямокутника = " + area(5, 7));

    Square s = new Square(5);
    System.out.println("Площа через обєкт = " + s.area());

    Rectangle r = new Rectangle(3, 5);
    System.out.println("Площа прямокутника через обєкт = " + r.area());
  }

  public static void hello(String a) {
    System.out.println(" Hello " + a);
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }


}