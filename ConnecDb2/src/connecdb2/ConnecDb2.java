/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecdb2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Brahian Vera
 */
public class ConnecDb2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con  = null;
        Statement pstm = null;
        ResultSet rs = null;
        
        String sql = "select * from Customer";
        
        try {
            con = Conexion.getConexion();
            pstm = con.createStatement();
            rs = pstm.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getInt(1)+ ", ");
                System.out.println(rs.getString("Name"));
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
}
