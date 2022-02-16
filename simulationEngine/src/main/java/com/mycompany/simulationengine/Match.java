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
public class Match {
    StringBuilder score = new StringBuilder();
    String[] matchLog = new String[18];
    int homesTeamNumGol = 0;
    int awaysTeamNumGol = 0;
    public Match(Team homeTeam,Team awayTeam){
        this.setScore(homeTeam,this.homesTeamNumGol,awayTeam, this.awaysTeamNumGol);
    }
    
    public void addGol(String whoAttack, Boolean gool, Team homeTeam, Team awayTeam){
        if(!gool){
            return;
        }
        if(whoAttack == "homeTeam"){
            this.homesTeamNumGol++;
        }else{
            this.awaysTeamNumGol++;
        }
        setScore(homeTeam, this.homesTeamNumGol, awayTeam, this.awaysTeamNumGol);
    }
    
    public void setScore(Team teamHome, int homeSTeamGol, Team teamAway, int awaysTeamGol){
        this.score.replace(0,this.score.length(),teamAway.abbrevitedName+" "+homeSTeamGol+" - "+awaysTeamGol+" "+teamHome.abbrevitedName);
        
    }
    
    public void setMacthLog(int minute,String team, int percent, Boolean gool ){
        int lessPosition = 1;
        int positionMatchLog = minute / SimulationEngine.INTERVALS;
        positionMatchLog = positionMatchLog - lessPosition;
        matchLog[positionMatchLog] = Integer.toString(minute)+"||"+team+"||"+percent+"||"+"Gol:"+gool;
    } 
}
