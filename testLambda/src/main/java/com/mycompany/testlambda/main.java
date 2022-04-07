/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testlambda;

import java.util.List;

/**
 *
 * @author Brahian Vera
 */
public class main {
    
    public static void main(String[] args) {
        //EligiblePerson eTester = new DriverEligibilityTester();
        List<Person> pl = Person.createShortList();
        //Forma de llamar antes si una expresion Lambda 
        /*robocallEligible(new EligiblePerson(){ 
            public boolean isEligigle(Person p) {
                return p.getAge() >= 16;
            } 
        },
        pl);
        */
        //robocallEligible((Person p) -> p.getAge() >= 26,pl);
        //Para el servicio
        //System.out.println("Gente que presentara servicio militar");
        //robocallEligible((Person p) -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE,pl);
        //
        //Drivers
        robocallEligible((Person p) -> p.getAge() >= 16,pl);
        //Voters
        robocallEligible((Person p) -> p.getAge() >= 18,pl);
        //Residents
        robocallEligible((Person p) -> p.getCity() == "Denver",pl);
        //Rango de edad
        robocallEligible((Person p) -> p.getAge() >= 18 && p.getAge() <= 25,pl);
        
    }
     public static void robocallEligible(Predicate<Person>pred, List<Person> pl){
        for(Person p: pl){
            if(pred.test(p)){
                String num=p.getPhone();
                RoboCall.robocall(num);
            }
        }
    } 
    
}
