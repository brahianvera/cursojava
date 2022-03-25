/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testlambda;

import java.rmi.StubNotFoundException;
import java.util.List;

/**
 *
 * @author Brahian Vera
 */
public class RoboCall {
  
  public void callDrivers(List<Person> pl){
    for(Person p:pl){
      if (p.getAge() >= 16){
        roboCall(p);
      }
    }
  }
  
  public void emailDraftees(List<Person> pl){
    for(Person p:pl){
      if (p.getAge() >= 18 
        && p.getAge() <= 25 
        && p.getGender() == Gender.MALE){
        
        roboEmail(p);
      }
    }
  }
  
  public void mailPilots(List<Person> pl){
    for(Person p:pl){
      if (p.getAge() >= 23 
        && p.getAge() <= 65){
        
        roboMail(p);
      }
    }
  }
 
  public static void robocall (String number){
      System.out.println("Llamando aa...."+number);
  }
  
  public void roboCall(Person p){
    System.out.println("Calling " + p.getGivenName() 
      + " " + p.getSurName() + " age " 
      + p.getAge() + " at " + p.getPhone());
  }
  
  public void roboEmail(Person p){
    System.out.println("EMailing " + p.getGivenName() 
      + " " + p.getSurName() + " age " + p.getAge() 
      + " at " + p.getEmail());
  }
  
  public void roboMail(Person p){
    System.out.println("Mailing " + p.getGivenName() 
      + " " + p.getSurName() + " age " + p.getAge() 
      + " at " + p.getAddress() + ", " + p.getCity() 
      + ", " + p.getState() + " " + p.getCode());
  }
}