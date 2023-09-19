/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author JIMMY
 */
public class Conexion {
    
    private static String clase = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/farmacia?serverTimezone=UTC";
    private static String usuario = "root";
    private static String clave = "123456";
    
    public Conexion(){
        
    }
    
    public Connection conectar(){
        Connection link = null;
        try {
            
            Class.forName(clase);
            link = DriverManager.getConnection(url, usuario, clave);
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return link;
    }
    
}
