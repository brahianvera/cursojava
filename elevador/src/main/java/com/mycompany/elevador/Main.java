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
public class Main {
    
    public static void main(String args[]){
        
        //-------------------- Test 1a: El elevador sk debería moverse por tener las puertas cerradas -----------------------------------------  ?? Preguntar
        //DADO
        Elevador elevador = new Elevador();
        elevador.piso = 1;
        boolean isOk = false;
        int expectedLevel = 2;
        String okMessage = "Ok";
        String notOkMessage = "No OK";
        
        //CUANDO
        elevador.subir();

        //ENTONCES
        // Aca deberia salir false
        isOk = elevador.piso == expectedLevel;
        if(isOk){
            System.out.println("Test 1: " + okMessage); //Espero que se imprima 1
        }else{
            System.out.println("Test 1a: " + notOkMessage); //Espero que se imprima 1
        }
        
       
        
        //-------------------- Test 1b: El elevador no debería moverse por tener las puertas abiertas -----------------------------------------

        //DADO
        elevador.piso = 1;
        elevador.abrir();
        expectedLevel = 1;
        isOk = false;
           
        //CUANDO
        elevador.subir();
        
        //Entonces
        isOk = elevador.piso == expectedLevel;
        if(isOk){
            System.out.println("Test 1b: " + okMessage);
        }else{
            System.out.println("Test 1b: " + notOkMessage);
        }
        
        
        //------------------------- Test 2a: El elevador no deberia bajar por tener las puertas abiertas
        elevador.piso = 2;
        elevador.abrir();
        expectedLevel = 2;
        isOk = false;
        
        //Cuando
        elevador.bajar();
        
        
        //Entonces
        isOk = elevador.piso == expectedLevel;
        if(isOk){
            System.out.println("Test 2a: "+okMessage);
        }else{
            System.out.println("Test 2a: "+notOkMessage);
        }
        
        //------------------------- Test 2 b: El elevador deberia moverse por tener las puertas cerradas
        elevador.piso = 2;
        elevador.cerrar();
        expectedLevel = 1;
        isOk = false;
        
        //Cuando
        elevador.bajar();
        
        
        //Entonces
        isOk = elevador.piso == expectedLevel;
        if(isOk){
            System.out.println("Test 2b: "+okMessage);
        }else{
            System.out.println("Test 2b: "+notOkMessage);
        }
        
        //-------------------------------------------------------------
        Elevador elevador3 = new Elevador();
        //DADO
        elevador3.cerrar();
        elevador3.piso = 5; //El edificio tiene 10 pisos
                
        //CUANDO
        elevador3.subir();

        //ENTONCES
        isOk = elevador3.piso == 10;

        if(isOk){
            System.out.println("Test 4a: " + okMessage);
        }else{
            System.out.println("Test 4b: " + notOkMessage);
        }
        
        elevador3.ValidarPiso(0);
        
        
        ElevatorBySteps elevador4 = new ElevatorBySteps("EVEN");
        elevador4.cerrar();
        elevador4.toUp();
        System.out.println("Estas en el piso: "+elevador4.piso);
        
        ElevatorBySteps elevador5 = new ElevatorBySteps("ODD");
        elevador5.cerrar();
        elevador5.toUp();
        System.out.println("Estas en el piso: "+elevador5.piso);;
        
    }
}
