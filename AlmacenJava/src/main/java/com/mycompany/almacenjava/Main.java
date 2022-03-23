/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.almacenjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Brahian Vera
 */
public class Main {
    
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        HashMap<Integer,Producto> productos = new HashMap();
        int option = 0;      
        menu menu = new menu();
        
        System.out.println("Bienvenido al almacen DE ROPA JAVA");
        productos = menu.getMenu();
        Factura factura = new  Factura();
        do{
            System.out.println("Estos son los productos disponibles");
            menu.showMenu(productos);
            System.out.println("¿Cual quieres comprar?");
            option = reader.nextInt();
            Producto producto = productos.get(option);
            producto.setNumProdcuto(1);
            productos.put(option,producto);
            factura.mostrarFactura(productos,"Factura");
            System.out.println("Desea salir 1-Si , 2 - No");
            option = reader.nextInt();
            
        }while(option != 1);
        
        factura.mostrarFactura(productos,"Factura final");
        System.out.println("Valor con descuento: "+factura.getTotalWithDiscount());
       
        
    }
    
}
