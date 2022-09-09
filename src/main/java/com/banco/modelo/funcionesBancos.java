package com.banco.modelo;

import com.banco.connector.conexion;

import java.sql.Connection;

public class funcionesBancos {

    public Connection cn;

    public funcionesBancos() {

        conexion sn = new conexion();
        cn = sn.conexion();
    }




}
