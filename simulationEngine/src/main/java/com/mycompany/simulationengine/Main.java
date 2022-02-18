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
public class Main {
    
    public static void main(String args[]){
        Team homeTeam = new Team("Barcelona", "BCN");
        Team awayTeam = new Team("Real Madrid", "RM");
        if(!homeTeam.setFormation(4, 3, 3)){
            System.out.println(homeTeam.nameTeam+": Formacion invalida - partido cancelado");
            return;
        } else if(!awayTeam.setFormation(4, 4, 2)){
            System.out.println(homeTeam.nameTeam+": Formacion invalida - partido cancelado");
            return;
        }
        SimulationEngine simulationEngine = new SimulationEngine();
        Match match = simulationEngine.simulateMatch(homeTeam,awayTeam);
        
        System.out.println("|||| Marcador ||||");
        System.out.println(match.score);
        
        System.out.println("||| Log del partido ||||");
        System.out.println(match.matchLog.toString());
    }
}
