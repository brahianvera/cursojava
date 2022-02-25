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
public class Elevador {
    int piso;
    boolean puertaAbierta;
    //CONSTANTE - usando mayusculas. 
    final int MAX_PISO;
    final int MIN_PISO;
    
    public Elevador(){
        this.MAX_PISO = 10;
        this.MIN_PISO = 1;
        this.piso = 2;
    }
    
    void subir(){
        if(this.puertaAbierta == false && this.piso < this.MAX_PISO){
            this.piso = this.piso + 1;
        }
    }
    void bajar(){
        if(this.puertaAbierta == false && this.piso > this.MIN_PISO){
            this.piso = this.piso - 1;
        }
    }
    
    
    void cerrar(){
        this.puertaAbierta = false;
    }
    
    void abrir(){
        this.puertaAbierta = true;
    }
    
    void ValidarPiso(int pisorequerido){
        if(pisorequerido > this.MAX_PISO || pisorequerido < this.MIN_PISO ){
            System.out.println("No existe el piso requerido");
        }else{
            int oprimir = 0;
            if(pisorequerido > this.piso){
                oprimir = pisorequerido - this.piso;
                System.out.println("Oprime "+oprimir+" veces  el boton de subir para llegar a este piso");
            }else if(pisorequerido < this.piso){
                oprimir = this.piso - pisorequerido;
                System.out.println("Oprime "+oprimir+" veces el boton de bajar para llegar a este piso");
            }
            else{
                System.out.println("Estas en el piso requerido");
            }
        }
        
    }
    
}
