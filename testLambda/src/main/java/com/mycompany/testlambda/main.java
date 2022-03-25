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
        EligiblePerson eTester = new DriverEligibilityTester();
        List<Person> pl = Person.createShortList();
        robocallEligible(new EligiblePerson(){ 
            public boolean isEligigle(Person p) {
                return p.getAge() >= 16;
            } 
        },
        pl);
    }
     public static void robocallEligible(EligiblePerson tester, List<Person> pl){
        for(Person p: pl){
            if(tester.isEligigle(p)){
                String num=p.getPhone();
                RoboCall.robocall(num);
            }
        }
    } 
    
}
