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
    String score = new String();
    StringBuilder matchLog = new StringBuilder();
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
        this.score = teamAway.abbrevitedName+" "+awaysTeamGol+" - "+homeSTeamGol+" "+teamHome.abbrevitedName;
        
    }
    
    public void setMacthLog(int minute,String team, int percent, Boolean gool ){
        matchLog.append(Integer.toString(minute)+" - "+team+" - "+percent+" - "+"Gol:"+gool+" \n");
    } 
}
