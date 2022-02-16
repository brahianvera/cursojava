/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simulationengine;

/**
 *
 * @author Brahian Vera
 */
public class Team {
    public int forwardsNumbers;
    public int defenderNumbers;
    public int midFielderNumbers;
    public String nameTeam = "";
    public String abbrevitedName = "";
    
    public Team(String nameTeam, String abbrevitedName){
        this.nameTeam  = nameTeam;
        this.abbrevitedName = abbrevitedName;
    }
    
    
    public Boolean setFormation(int forwardsNumbers, int defenderNumbers, int midFielderNumbers){
        Boolean validFormation;
        validFormation = this.validateFormation(forwardsNumbers,defenderNumbers,midFielderNumbers);
        if(validFormation){
            this.forwardsNumbers = forwardsNumbers;
            this.defenderNumbers = defenderNumbers;
            this.midFielderNumbers = midFielderNumbers;
            System.out.println(this.abbrevitedName+" ¡Formacion Creada!... Vamos por el  Gol");
        }else{
            System.out.println("Formacion invalida.");
        }
        return validFormation;
    }
    
    public Boolean validateFormation(int forwardsNumbers, int defenderNumbers, int midFielderNumbers){
        Boolean validFormation = true;
        int goalkeeper = 1;
        if(midFielderNumbers < 2 ){
            validFormation = false;
        }
        int playersNum = forwardsNumbers+defenderNumbers+midFielderNumbers+goalkeeper;
        if( playersNum != 11){
            validFormation = false;
        }
        return validFormation;
    }
}
