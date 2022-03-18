/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapearlibreria;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Brahian Vera
 */
public class Main {
    
    public static void main (String args[]) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Libreria libreria = (Libreria) unmarshaller.unmarshal(new File("libros.xml"));
        System.out.println(libreria.getNombre());
        
        ArrayList<Libro> libros = libreria.getLibros();
        
        for(Libro libro : libros){
            System.out.println("isbn: "+libro.getIsbn());
            Genero genero = libro.getGenero();
            System.out.println("Tema: "+genero.getTema());
            System.out.println("Titulo: "+genero.getTitulo());
            System.out.println("Autor: "+genero.getAutor());
            System.out.println("");
        }
        
    }
    
}
