/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matriz;

/**
 *
 * @author Brahian Vera
 */
public class WaysToRead {
    
    int [][] matriz;
    int tam;
    
    public WaysToRead(int[][] matriz, int tam){
        this.matriz = matriz;
        this.tam = tam;
    }
    
    public void readVertical(){
        int col = 0;
         for(int rec = 1; rec <= this.tam; rec++){
            if(rec % 2 != 0){
                readToDown(col);  
            }else{
                readToUp(col);
            }
            System.out.println("");
            col++;
        }
    }
  
    public void readHorizontal(){
        for(int fil = 0; fil < this.tam; fil++){
            if(fil % 2 != 0){
                this.readBackward(fil);
            }else{
                this.readFordward(fil);
            }
        }
    }
    
    public void readZ(){
        int first_fil = 0;
        int last_fil = this.tam -1;
        int col;
        int column_discount = 1;
        for(int fil  = 0; fil <  this.tam; fil++){
            System.out.println("");
            if(fil  == first_fil){
                readFordward(fil);
            }else if(fil == last_fil){
                readFordward(fil);
            }else{
                col = (this.tam - fil) - column_discount;
                System.out.print(getSpace(col)+this.matriz[fil][col]);
            }
        }
    }
    
    public void readN(){
        int first_col = 0;
        int last_col = this.tam -1;
        int col;
        int column_discount = 1;
        for(int fil  = 0; fil <  this.tam; fil++){
            System.out.print(this.matriz[fil][first_col]);
            if(fil == first_col || fil == last_col){
                System.out.print(getSpace(this.tam-2));
            }else{
                col = fil;
                System.out.print(" "+this.matriz[fil][col]);
            }
            System.out.print(this.matriz[fil][last_col]);
            System.out.println("");
        }
    }
    
    public String getSpace (int num_spaces){
        String spaces = "";
        for(int i =0;i < num_spaces; i++){
            spaces += "  ";
        }
        return spaces;
    }
    
    public void readFordward(int fil){
        for(int col = 0; col < this.tam; col++){
            System.out.print(this.matriz[fil][col]+" ");
            
        }
    }
    
    public void readBackward(int fil){
        for(int col = (this.tam-1); col >= 0; col--){
            System.out.print(this.matriz[fil][col]+" ");
        }
    }
    
    public void readToDown(int col){
        for(int fil = 0; fil < this.matriz.length; fil++){
            System.out.print(this.matriz[fil][col] + " ");
        }   
    }
    
    public void readToUp(int col){
        for(int fil = (this.tam-1); fil > -1; fil--){
            System.out.print(this.matriz[fil][col] + " ");
        }
    }
}
