/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matriz;
import java.util.Scanner;

    
/**
 *
 * @author Brahian Vera
 */
public class Main {
    
 
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);  
        System.out.println("1. Recorrido Vertical");
        System.out.println("2. Recorrido Horizontal");
        System.out.println("3. Recorrido Z");
        System.out.println("4. Recorrido N");
        System.out.println("Ingrese una opcion:");
        int opc = sc.nextInt();
        
        System.out.println("Ingrese tamaño de matrix");
        int tam = sc.nextInt();
        
        int[][] matriz = new int[tam][tam];
        
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                System.out.println("Ingrese el valor para la posicion ["+i+","+j+"]");
                matriz[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Los valores de la matrix son los siguientes");
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                System.out.print(" "+matriz[i][j]);
            }
            System.out.println("");
        }
       
        WaysToRead waysToRead = new WaysToRead(matriz, tam);
        
        if(opc == 1){
            waysToRead.readVertical();
        }else if(opc == 2){
            waysToRead.readHorizontal();
        }else if(opc == 3){
            waysToRead.readZ();
        }else if(opc == 4){
            waysToRead.readN();
        }
        
        
    }
}
