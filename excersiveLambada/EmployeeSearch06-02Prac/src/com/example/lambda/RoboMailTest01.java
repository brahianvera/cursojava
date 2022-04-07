package com.example.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Oracle
 * Reuse lambda expressions
 */
public class RoboMailTest01 {
  
  public static void main(String[] args) {
    
    List<Employee> pl = Employee.createShortList();
    RoboMail01 robo = new RoboMail01();
    
    Predicate<Employee> salesExecutives = (Employee e) -> e.getDept().equals("Sales") && e.getRole().equals(Role.EXECUTIVE); // Define lambda for this
    
    Predicate<Employee> salesEmployeesOver50  = (Employee e) -> e.getAge() >= 50 && e.getDept().equals("Sales");
    
    System.out.println("\n==== RoboMail 01");
    System.out.println("\n=== Sales Execs ===");
    robo.mail(pl,salesExecutives);
    robo.text(pl, salesExecutives);
    //robo.mail();  // Update with Lambda variable
    //robo.text(); // Update with Lambda variable
    
    System.out.println("\n=== All Sales ===");
    robo.mail(pl, salesEmployeesOver50);
    robo.text(pl, salesEmployeesOver50);
  }
}
