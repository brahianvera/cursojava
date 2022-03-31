/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Banda;
import conecdb.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanamell
 */
public class BandaDao {

    public List<Banda> getBandas() {

        String sql = "select * from banda";
        List<Banda> lista = new ArrayList<>();

        try (Connection con = Conexion.getConexion();
                PreparedStatement pstm = con.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Banda banda = new Banda();
                banda.setIdBanda(rs.getInt(1));
                banda.setNomBanda(rs.getString(2));
                lista.add(banda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
   public String insertar(String banda){
       String message = null;
       String sec = "select max(idbanda)+1 from banda";
       String sql = "INSERT INTO banda(idbanda,nombanda) VALUES (?,?)";
       try(Connection con = Conexion.getConexion();
            PreparedStatement ps1 = con.prepareStatement(sec);
            PreparedStatement ps2 = con.prepareStatement(sql);
            ResultSet rs =  ps1.executeQuery()){
            if(rs.next()){
                int max = rs.getInt(1);
                ps2.setInt(1, max);
                ps2.setString(2, banda);
            }
            
            if(ps2.executeUpdate() != 1){
                throw new RuntimeException("Error en la inserccion....");
            }else{
                message = "Inserccion exitosa";
            }
               
           
       }catch(Exception ex){
           ex.printStackTrace();
       }
       
       return message;
   }
   
   public String updateBanda(int idBanda,String Name){
       String message = null;
       String sql = "update banda set nombanda=? where idbanda=?";
        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);  
                ){
            ps.setString(1, Name);
            ps.setInt(2, idBanda);
            if(ps.executeUpdate() > 0){
                message = "Actualizacion exitosa";
            }else{
                message = "Actualizacion fallida";
            }
        }
        catch(Exception ex){
           ex.printStackTrace();
        }
       return message;
   }

}
