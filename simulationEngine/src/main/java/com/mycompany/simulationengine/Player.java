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
public class Player {
    
     private String position;
     private boolean isStarPlayer;
     
     
     public Player(String position, boolean isStarPlayer){
         this.position = position;
         this.isStarPlayer = isStarPlayer;
     }
     
     public boolean getIsStarPlayer(){
        return this.isStarPlayer;
     }
     
     public String getposition(){
        return this.position; 
     }
     
}
