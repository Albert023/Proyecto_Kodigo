package com.banco.connector;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {

    public Connection conexion(){
        String baseDeDatos = "dbbanco";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

        Connection conexion = null;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }


}
