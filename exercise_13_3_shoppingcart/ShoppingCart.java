/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercise_13_3_shoppingcart;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Brahian Vera
 */
public class ShoppingCart {
    ArrayList<Item> items = new ArrayList();
    
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.fillCart();
        cart.removeItemFromCart("Trousers");
    }
    
    public void fillCart(){
        items.add(new Shirt(40.95,'M','R'));
        items.add(new Shirt(32.99,'M','Y'));
        items.add(new Trousers(59.99,34,'B',"Relaxed",'M'));
        items.add(new Trousers(75.50,8,'G',"Skinny",'F'));
        removeItemFromCart("Trousers");
        
        //Unario: Recibe un parametro  y retorna valor del mismo tipo del parametro
        items.replaceAll(item -> {
            item.setDesc(item.getDesc().toUpperCase());
            return item;        
        });
        
        //Consumidor: recibe parametros pero no retorna
        items.stream().forEach(item->System.out.println(item.getDesc()));
        
    }
    
    public void removeItemFromCart(String desc){
        // remove all Trousers from the items list, then print out the list
        //Predicado: toma una unica entrada y retorna un booleano
        this.items.removeIf(item -> item.getDesc() == desc);
    }
    
}
