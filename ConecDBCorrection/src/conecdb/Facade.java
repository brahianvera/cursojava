/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecdb;

import Dao.BandaDao;
import Entidades.Banda;
import java.util.List;

/**
 *
 * @author juanamell
 */
public class Facade {
    
    public List<Banda> obtenerBandas(){
        BandaDao band = new BandaDao();
        return band.getBandas();
    }
    
    //metodo para insertar; 
    
    public String insertarBanda(String banda){
        BandaDao bd = new BandaDao();
        return bd.insertar(banda);
    }
    
    public String actualizarBanda(int idbanda, String nombanda){
        BandaDao bd = new BandaDao();
        return bd.updateBanda(idbanda, nombanda);
    }
    
    public String procesoDelete(int idbanda){
        BandaDao bd = new BandaDao();
        return  bd.deleteBanda(idbanda);
    }
}
