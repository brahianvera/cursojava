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
    private String turnAttac  = "homeTeam";
    int[] probabilityBarHomeTeam = new int[2];
    int[] probabilityBarAwayTeam = new int[2];
    
    
    public void generateProbabilityBars(Team teamHome, Team teamAway){
        int teamHomeDefenderPercent = teamHome.defenderNumbers *  DEFENDER_PERCENT;
        int teamAwayDefenderPercent = teamAway.defenderNumbers * DEFENDER_PERCENT;
        int teamHomeAttackPercent =  teamHome.forwardsNumbers * ATTACK_PERCENT;
        int teamAwayAttackPercent = teamAway.forwardsNumbers * ATTACK_PERCENT;
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
        Boolean isGool;
        String nameTeamToLog = "";
        int delta = 5;
        for(int currentTime = 0; currentTime < time; currentTime+=delta){
            golProbability =  (int)((Math.random()*100)+1);
            whoAttack = this.whoAttack();
            isGool = this.resultMove(golProbability,whoAttack);
            if(whoAttack == "homeTeam"){
                nameTeamToLog = "Complete Name: "+homeTeam.nameTeam+" ABREVIATE NAME: "+homeTeam.abbrevitedName;
            }else{
                nameTeamToLog = "Complete Name: "+awayTeam.nameTeam+" ABREVIATE NAME: "+awayTeam.abbrevitedName;
            }
           match.setMacthLog(currentTime+delta, nameTeamToLog, golProbability, isGool);
           match.addGol(whoAttack,isGool,homeTeam,awayTeam);
           
        }
        return match;
    }
    
      public Boolean resultMove(int percentAttack, String whoAttack){
        if(whoAttack == "awayTeam"){
            return isGool(percentAttack, this.probabilityBarAwayTeam);
        }else{
            return isGool(percentAttack, this.probabilityBarHomeTeam);
        }   
    }
    
    public Boolean isGool(int percentAttack ,int [] probabilityBarTeam){
        int defenderPercent = 0;
        int attackPercent = 1;
        return probabilityBarTeam[defenderPercent] > percentAttack && percentAttack <= probabilityBarTeam[attackPercent];
    }
    
    private String whoAttack(){
        if(this.turnAttac == "homeTeam"){
            this.turnAttac = "awayTeam";
            return "homeTeam";
        }else{
            this.turnAttac = "homeTeam";
            return "awayTeam";
        }
    }
}
