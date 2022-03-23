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
public class Factura implements precios{
    
    private double totalWithOutOff = 0;
    private double totalWithDiscount = 0;
    private double percentDiscount;
    public Factura(){
    
    }
    
    public void mostrarFactura(HashMap<Integer,Producto> productos, String enunciado){
        Set <Integer> keys = productos.keySet();
        Producto producto;
        int total;
        System.out.println("");
        System.out.println("---- "+enunciado+": ---");
        int totalValueAllProduct = 0;
        for(Integer key: keys){
            producto = productos.get(key);
            int valueItem = getPriceItem(producto);
            int numProducto = productos.get(key).getNumProdcuto();
            int totalValueProduct = getTotalValueItem(valueItem, numProducto);
            totalValueAllProduct += totalValueProduct;
            System.out.println( productos.get(key).getName()+ " : "+numProducto+" : "+totalValueProduct);
        }
        this.totalWithOutOff = totalValueAllProduct;
        System.out.println("Valor total sin descuento: "+totalValueAllProduct);
        System.err.println("");
    }
    
    public double getTotalWithDiscount(){
        this.percentDiscount = (this.getPorcentDiscount()/100);
        System.out.println(this.percentDiscount);
        this.totalWithDiscount = this.totalWithOutOff - (this.totalWithOutOff * this.percentDiscount);
        return this.totalWithDiscount;
    }
    
    private double getPorcentDiscount(){
        double discount = 0;
        if(this.totalWithOutOff > 0 && this.totalWithOutOff <= 100000){
            discount = 5;
        }else if(this.totalWithOutOff > 100000 && this.totalWithOutOff <= 300000){
            discount = 10;
        }else if(this.totalWithOutOff > 300000 && this.totalWithOutOff <= 500000){
            discount = 20;
        }else if(this.totalWithOutOff > 500000){
            discount = 30;
        }
        return discount;
    }

    
    private int getTotalValueItem(int itemValue, int cantidad){
        return itemValue * cantidad;
    }
    
    
    private int getPriceItem(Producto producto){
        int itemValue = 0;
        if(producto instanceof Calcetines){
            Calcetines calcetin = new Calcetines();
            itemValue = calcetin.price;
        }
        if(producto instanceof Camisa){
            Camisa camisa = new Camisa();
            itemValue = camisa.price;
        }
        if(producto instanceof Chaqueta){
            Chaqueta chaqueta = new Chaqueta();
            itemValue = chaqueta.price;
        }
        if(producto instanceof Cinturon){
            Cinturon cinturon = new Cinturon();
            itemValue = cinturon.price;
        }
        if(producto instanceof Pantalon){
            Pantalon pantalon = new Pantalon();
            itemValue = pantalon.price;
        }
        return itemValue;
    }
    
    public double getTotalWithOutOff() {
        return totalWithOutOff;
    }

    public void setTotalWithOutOff(double totalWithOutOff) {
        this.totalWithOutOff = totalWithOutOff;
    }
}
