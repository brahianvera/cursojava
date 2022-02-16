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
public class SimulationEngine {
    static final int ATTACK_PERCENT = 5;
    static final int DEFENDER_PERCENT = 5;
    static final int INTERVALS = 5;
    
    int[] probabilityBarHomeTeam = new int[2];
    int[] probabilityBarAwayTeam = new int[2];
    
    public void generateProbabilityBars(Team teamHome, Team teamAway){
        int teamHomeDefenderPercent = teamHome.defenderNumbers *  SimulationEngine.DEFENDER_PERCENT;
        int teamAwayDefenderPercent = teamAway.defenderNumbers * SimulationEngine.DEFENDER_PERCENT;
        int teamHomeAttackPercent =  teamHome.forwardsNumbers * SimulationEngine.ATTACK_PERCENT;
        int teamAwayAttackPercent = teamAway.forwardsNumbers * SimulationEngine.ATTACK_PERCENT;
        probabilityBarHomeTeam[0] = teamAwayDefenderPercent;
        probabilityBarHomeTeam[1] = teamHomeAttackPercent;
        probabilityBarAwayTeam[0] = teamHomeDefenderPercent;
        probabilityBarAwayTeam[1] = teamAwayAttackPercent;
    }
    
    public Match simulateMatch(Team homeTeam, Team  awayTeam){
        Match match = new Match(homeTeam, awayTeam);
        generateProbabilityBars(homeTeam, awayTeam);
        int time = 90;
        String whoAttack;
        int golProbability;
        Boolean Gool;
        String whoAttackName;
        String whoAttackAbreviateName;
        int initTime = 5;
        for(int currentTime = 0; currentTime < time; currentTime = currentTime+5){
            whoAttack = whoAttack();
            golProbability =  (int)(Math.random()*101);
            Gool = this.resultMove(golProbability,whoAttack);
            if(whoAttack == "homeTeam"){
                whoAttackName = homeTeam.nameTeam;
                whoAttackAbreviateName = homeTeam.abbrevitedName;
            }else{
                whoAttackName = awayTeam.nameTeam;
                whoAttackAbreviateName = homeTeam.abbrevitedName;
            }
           String nameTeamToLog = "Complete Name: "+whoAttackName+" ABREVIATE NAME: "+whoAttackAbreviateName;
           match.setMacthLog(currentTime+initTime, nameTeamToLog, golProbability, Gool);
           match.addGol(whoAttack,Gool,homeTeam,awayTeam);
           
        }
        return match;
    }
    
   
    public Boolean resultMove(int percentAttack, String whoAttack){
  
        if(whoAttack == "awayTeam"){
            return Gool(percentAttack, this.probabilityBarAwayTeam);
        }else{
            return Gool(percentAttack, this.probabilityBarHomeTeam);
        }   
    }
    
    public Boolean Gool(int percentAttack ,int [] probabilityBarTeam){
        int defenderPercent = 0;
        int attackPercent = 1;
        return probabilityBarTeam[defenderPercent] > percentAttack && percentAttack <= probabilityBarTeam[attackPercent];
    }
    
    public String whoAttack(){
        int whoAttack =  (int)(Math.random()*2);
        int homeTeam = 0;
        if(whoAttack == homeTeam){
            return "homeTeam";
        }else{
            return "awayTeam";
        }
    }
}
