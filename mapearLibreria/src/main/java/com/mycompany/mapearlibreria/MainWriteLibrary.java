/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapearlibreria;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Brahian Vera
 */
public class MainWriteLibrary {
    public static void main (String args[]) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Marshaller marshaller = context.createMarshaller();
        Libreria libreria = new Libreria();
        
        libreria.setNombre("LAS AVENTURAS DE BOGOTA");
        
        ArrayList<Libro> libros = new ArrayList();
        Libro libro = new Libro();
        libro.setIsbn("2345");
        Genero genero = new Genero();
        genero.setTema("Aventura");
        genero.setTitulo("EL senor de los anillos");
        genero.setAutor("J.R.R Tolkien");
        libro.setGenero(genero);
        libros.add(libro);
        
        libro = new Libro();
        libro.setIsbn("7892");
        genero = new Genero();
        genero.setTema("Terror");
        genero.setTitulo("EL aro");
        genero.setAutor("Juan de lorca");
        libro.setGenero(genero);
        libros.add(libro);
        
        libro = new Libro();
        libro.setIsbn("4352");
        genero = new Genero();
        genero.setTema("Ficcion");
        genero.setTitulo("Star Wars episodio 6: El imperio atacara");
        genero.setAutor("Jorge Lucas");
        libro.setGenero(genero);
        libros.add(libro);
        
          libro = new Libro();
        libro.setIsbn("3525");
        genero = new Genero();
        genero.setTema("Ficcion");
        genero.setTitulo("Star Wars episodio 7: EL retorno del jedi");
        genero.setAutor("Jorge Lucas");
        libro.setGenero(genero);
        libros.add(libro);
        
        libro = new Libro();
        libro.setIsbn("7892");
        genero = new Genero();
        genero.setTema("Apocalipsis");
        genero.setTitulo("Los juegos del hambre");
        genero.setAutor("Leydi gamboa");
        libro.setGenero(genero);
        libros.add(libro);
        
        libreria.setLibros(libros);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(libreria, System.out);
        marshaller.marshal(libreria, new FileWriter("nuevalibreria.xml"));
        
         //Esto sirve para que lo muestre como un XML
        /*marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(disqueria, System.out);
        marshaller.marshal(disqueria, new FileWriter("metal.xml"));*/
        
        System.out.println("");
        
        
    }
    
}
