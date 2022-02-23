/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simulationengine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Brahian Vera
 */
public class Match {
    private String score = new String();
    private StringBuilder matchLog = new StringBuilder();
    private int homesTeamNumGol = 0;
    private int awaysTeamNumGol = 0;
    
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
        this.score = teamAway.getAbbrevitedName()+" "+awaysTeamGol+" - "+homeSTeamGol+" "+teamHome.getAbbrevitedName();
        
    }
    
    public void setMacthLog(int minute,String team, int percent, Boolean gool){
        LocalDateTime today = LocalDateTime.now();
        
        matchLog.append(today.format(DateTimeFormatter.ISO_LOCAL_DATE)+" - "+today.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME)+" - "+Integer.toString(minute)+" - "+team+" - "+percent+" - "+"Gol:"+gool+" \n");
    } 
    
    public String getScore(){
        return this.score;
    }
    
    public StringBuilder getmatchLog(){
        return this.matchLog;
    }
}
