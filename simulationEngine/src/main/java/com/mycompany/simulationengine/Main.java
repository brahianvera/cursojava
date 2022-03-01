/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simulationengine;

import java.util.ArrayList;

/**
 *
 * @author Brahian Vera
 */
public class Main {
    
    public static void main(String args[]){
        /*
        Team homeTeam = new Team("Barcelona", "BCN");
        Team awayTeam = new Team("Real Madrid", "RM");
        if(!homeTeam.setFormation(4, 3, 3)){
            System.out.println(homeTeam.getNameTeam()+": Formacion invalida - partido cancelado");
            return;
        } else if(!awayTeam.setFormation(4, 4, 2)){
            System.out.println(homeTeam.getNameTeam()+": Formacion invalida - partido cancelado");
            return;
        }
        SimulationEngine simulationEngine = new SimulationEngine(homeTeam,awayTeam);
        Match match = simulationEngine.simulateMatch(homeTeam,awayTeam);
        
        
        
        System.out.println("|||| Marcador ||||");
        System.out.println(match.getScore());
        
        System.out.println("||| Log del partido ||||");
        System.out.println(match.getmatchLog().toString());
        */
        
        ArrayList<Player> playersChelsea  = new ArrayList<>();
        playersChelsea.add(new Player("DF",false));
        playersChelsea.add(new Player("DF",true));
        playersChelsea.add(new Player("DF",false));
        playersChelsea.add(new Player("MF",true));
        playersChelsea.add(new Player("MF",true));
        playersChelsea.add(new Player("FW",true));
        playersChelsea.add(new Player("FW",true));
        playersChelsea.add(new Player("FW",false));
        playersChelsea.add(new Player("FW",false));
        playersChelsea.add(new Player("FW",true));
        
        Team2 homeTeam = new Team2("Chelsea", "CH", playersChelsea);
        if(!homeTeam.setFormation()){
           System.out.println(homeTeam.getNameTeam()+": Has perdido por default");
           return;
        };
         
        ArrayList<Player> playersBarcelona  = new ArrayList<>();
        playersBarcelona.add(new Player("DF",false));
        playersBarcelona.add(new Player("DF",true));
        playersBarcelona.add(new Player("DF",false));
        playersBarcelona.add(new Player("MF",true));
        playersBarcelona.add(new Player("MF",true));
        playersBarcelona.add(new Player("MF",true));
        playersBarcelona.add(new Player("FW",true));
        playersBarcelona.add(new Player("FW",false));
        playersBarcelona.add(new Player("FW",false));
        playersBarcelona.add(new Player("FW",true));
        
        Team2 awayTeam = new Team2("Barcelona", "BC", playersBarcelona);
        if(!awayTeam.setFormation()){
            System.out.println(awayTeam.getNameTeam()+": Has perdido por default");
            return;
        };
        
        SimulationEngine simulationEngine = new SimulationEngine(homeTeam,awayTeam);
        Match match = simulationEngine.simulateMatch(homeTeam,awayTeam);
        System.out.println("|||| Marcador ||||");
        System.out.println(match.getScore());
        System.out.println("||| Log del partido ||||");
        System.out.println(match.getmatchLog().toString());
    }
}
