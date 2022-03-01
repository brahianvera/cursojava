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
public class SimulationEngine2 extends SimulationEngine {
    private String turnAttac  = "homeTeam";
    private int[] probabilityBarHomeTeam = new int[2];
    private int[] probabilityBarAwayTeam = new int[2];
    
    
    public SimulationEngine2(Team teamHome, Team teamAway){
        super(teamHome,teamAway);
        Team2 teamHome2 = (Team2) teamHome;
        Team2 teamAway2 = (Team2) teamAway;
        int teamHomeDefenderPercent = (teamHome.getDefendersNumbers() *  super.DEFENDER_PERCENT) + teamHome2.getAdditionalProbabilityDefender();
        int teamAwayDefenderPercent = (teamAway.getDefendersNumbers() * super.DEFENDER_PERCENT) + teamAway2.getAdditionalProbabilityAttack();
        int teamHomeAttackPercent =  (teamHome.getForwardsNumbers() * super.ATTACK_PERCENT) + teamHome2.getAdditionalProbabilityAttack();
        int teamAwayAttackPercent = (teamAway.getForwardsNumbers() * super.ATTACK_PERCENT) + teamAway2.getAdditionalProbabilityAttack();
        probabilityBarHomeTeam[0] = teamAwayDefenderPercent;
        probabilityBarHomeTeam[1] = teamHomeAttackPercent;
        probabilityBarAwayTeam[0] = teamHomeDefenderPercent;
        probabilityBarAwayTeam[1] = teamAwayAttackPercent;
        
        
    }
    
    @Override
    public Match simulateMatch(Team homeTeam, Team  awayTeam){
        Match match = new Match(homeTeam, awayTeam);
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
                nameTeamToLog = "Complete Name: "+homeTeam.getNameTeam()+" ABREVIATE NAME: "+homeTeam.getAbbrevitedName();
            }else{
                nameTeamToLog = "Complete Name: "+awayTeam.getNameTeam()+" ABREVIATE NAME: "+awayTeam.getAbbrevitedName();
            }
           match.setMacthLog(currentTime+delta, nameTeamToLog, golProbability, isGool);
           match.addGol(whoAttack,isGool,homeTeam,awayTeam);
           
        }
        return match;
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
    
    
    public  int[] getProbabilityBarHomeTeam(){
        return this.probabilityBarHomeTeam;
    }
    
    public int[] getProbabilityBarAwayTeam(){
        return this.probabilityBarAwayTeam;
    }
    
    public void setProbabilityBarHomeTeam(int[] probabilityBarHomeTeam){
        this.probabilityBarHomeTeam = probabilityBarHomeTeam;
    }
    
    public void setProbabilityBarAwayTeam(int[] probabilityBarAwayTeam){
        this.probabilityBarAwayTeam = probabilityBarAwayTeam;
    }
    
}
