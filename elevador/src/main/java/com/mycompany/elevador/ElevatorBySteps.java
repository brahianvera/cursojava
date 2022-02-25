/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elevador;

/**
 *
 * @author Brahian Vera
 */
public class ElevatorBySteps  extends Elevador{
    private String step = ""; 
    
    public ElevatorBySteps(String step){
        this.step = step;
        if(this.step == "ODD"){
            super.piso = 1;
        }else if(this.step == "EVEN"){
            super.piso = 2;
        }
    }
   
    public String getStep(){
        return this.step;
    }
    
    public void toUp(){
        if(!isValidStepToUp()){
            System.out.println("No puedes subir");
            return;
        }
        super.piso += 2;
    }
    
    public boolean isValidStepToUp (){
        if(super.puertaAbierta || super.piso+2 > super.MAX_PISO){
            return false; 
        }
        return true;
    }
    
     public boolean isValidStepToDown (){
        if(super.puertaAbierta || super.piso-2 < super.MAX_PISO){
            return false; 
        }
        return true;
    }
    
    public void toDown(){
        if(!isValidStepToDown()){
            System.out.println("No puedes Bajar");
            return;
        }
        super.piso -= 2;
    }
}
