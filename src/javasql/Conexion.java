/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasql;

import java.sql.*;
/**
 *
 * @author Manolo
 */

public class Conexion {
    
    Connection conn = null;
    
    final String url = "jdbc:mysql://localhost:3306/";          //cadena de conexión
    final String dbName = "padel_land";                         //nombre de la base de datos
    final String driver = "com.mysql.jdbc.Driver";
    final String userName = "root";
    final String password = "";
    
    public Connection getConnection() {
        try{
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            
            if (!conn.isClosed())
                System.out.println("La conexión a la base de datos está en uso... ");
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
    
    public void desconectar() {
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}