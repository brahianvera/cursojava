/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecdb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brahian Vera
 */
public class Conexion {
    static Connection con;
    
    public static Connection getConexion() throws SQLException{
            String url = "jdbc:derby://localhost:1527/sample";
            con = DriverManager.getConnection(url,"app","app");
            return con;
    }
}