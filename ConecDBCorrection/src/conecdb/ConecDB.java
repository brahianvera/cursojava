/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecdb;

import Dao.BandaDao;
import Entidades.Banda;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Scanner;



/**
 *
 * @author juanamell
 */
public class ConecDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Facade fac = new Facade();
       iniciarProceso(fac);
       //procesoInsertar();
       //procesoActualizar();
       procesoDelete();
    }
    
    private static void iniciarProceso(Facade f){
        List<Banda> bandas = f.obtenerBandas();
        System.out.println("==== BANDAS ====");
        bandas.stream().map((k) -> {
            System.out.print(k.getIdBanda() + " - " );
            return k;
        }).forEachOrdered((k) -> {
            System.out.println(k.getNomBanda());
        });
    }
    
    private static void procesoInsertar(){
        Scanner x = new Scanner(System.in);
        System.out.println("Digite la banda a insertar:");
        String banda = x.nextLine();
        Facade fac = new Facade();
        System.out.println(fac.insertarBanda(banda));
    }
    
    private static void procesoActualizar(){
        Scanner x = new Scanner(System.in);
        System.out.println("id de la banda a actualizar ");
        int idbanda = Integer.parseInt(x.nextLine());
        System.out.println("nuevo nombre de banda");
        String nameBanda = x.nextLine();
        Facade fac = new Facade();
        System.out.println(fac.actualizarBanda(idbanda, nameBanda));
    }
    
    private static void procesoDelete(){
        Scanner x = new Scanner(System.in);
        System.out.println("id de la banda a eliminar");
        int idbanda = Integer.parseInt(x.nextLine());
        Facade fac = new Facade();
        System.out.println(fac.procesoDelete(idbanda));
    }
    
}
