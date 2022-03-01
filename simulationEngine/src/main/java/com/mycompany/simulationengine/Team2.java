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
public class Team2 extends Team{
    
    private ArrayList<Player> players = new ArrayList<>();
    private int additionalProbabilityDefender = 0;
    private int additionalProbabilityAttack = 0;
        
    public Team2(String nameTeam, String abbrevitedName,ArrayList<Player> players){
        super(nameTeam,abbrevitedName);
        this.players = players;
    }
    
    public Boolean setFormation(){
        int defendersNumbers = 0;
        int forwardsNumbers = 0;
        int midFielderNumbers = 0;
        
        for(Player player: players){
            if(player.getposition() ==  "DF"){
                defendersNumbers++;
            }else if(player.getposition() == "FW"){
                forwardsNumbers++;
            }else if(player.getposition() == "MF"){
                midFielderNumbers++;
            }
        }
        return super.setFormation(forwardsNumbers, defendersNumbers, midFielderNumbers);   
    }
    
    public void setAdditionalProbabilityDefender(boolean isStarPlayer){
        if(isStarPlayer){
            additionalProbabilityDefender += 3;
        }
    }
    
    public void setAdditionalProbabilityAttack(boolean isStarPlayer){
        if(isStarPlayer){
            additionalProbabilityAttack +=2;
        }
    }
    
    public int getAdditionalProbabilityDefender(){
        return this.additionalProbabilityDefender;
    }
    
    public int getAdditionalProbabilityAttack(){
        return this.additionalProbabilityAttack;
    }
    
}
