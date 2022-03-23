/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.almacenjava;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Brahian Vera
 */
public class menu implements precios{
    
    
    public menu(){
        this.fillProducts();
    }
    
    public HashMap getMenu(){
        HashMap<Integer,Producto> productos = new HashMap<>();
        Set<String> keys = this.productPrice.keySet();
        int numItem = 0;
        for(String key: keys){
            numItem += 1;
            productos = fillOptionsProducts(productos, key,numItem);
        }
        return productos;
    }
    
    public void showMenu(HashMap<Integer,Producto> productos){
        Set<Integer> keys = productos.keySet();
        for(Integer key: keys){
            System.out.println(key+ ") "+productos.get(key).getName()+" : "+this.productPrice.get(productos.get(key).getName()));
        }
    }
    
    
    private HashMap  fillOptionsProducts(HashMap<Integer,Producto> productos, String nameProduct, int numItem){
        if(nameProduct == "Camisa"){
            Camisa camisa = new Camisa();
            camisa.setName(nameProduct);
            productos.put(numItem,camisa);
        }else if(nameProduct == "Pantalón"){
            Pantalon pantalon = new Pantalon();
            pantalon.setName(nameProduct);
            productos.put(numItem,pantalon);
        }else if(nameProduct == "Chaqueta"){
            Chaqueta chaqueta = new Chaqueta();
            chaqueta.setName(nameProduct);
            productos.put(numItem,chaqueta);
        }else if(nameProduct == "Cinturón"){
            Cinturon cinturon = new Cinturon();
            cinturon.setName(nameProduct);
            productos.put(numItem,cinturon);
        }else if (nameProduct == "Calcetines"){
            Calcetines calcetines = new Calcetines();
            calcetines.setName(nameProduct);
            productos.put(numItem,calcetines);
        }
        return productos;
    }
}
