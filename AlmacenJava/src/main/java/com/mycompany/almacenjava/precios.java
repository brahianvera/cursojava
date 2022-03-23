/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.almacenjava;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Brahian Vera
 */
public interface precios {
    
    public Map<String,Integer> productPrice = new TreeMap();
    public 
    
    default void  fillProducts(){
        productPrice.put("Camisa", 50000);
        productPrice.put("Pantalón", 100000);
        productPrice.put("Chaqueta", 200000);               
        productPrice.put("Cinturón", 40000);
        productPrice.put("Calcetines", 20000);
    }
    
    
}
