package com.banco.modelo;

import com.banco.clases.Cliente;
import com.banco.connector.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    public Connection cn;
    static ResultSet rs;

    public login() {

        conexion sn = new conexion();
        cn = sn.conexion();
    }

    public boolean Login(Cliente ln) {
        boolean retorno = false;
        try {
            String sql = "SELECT * FROM clientes WHERE usuariocliente = ? AND clavecliente = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);

            cmd.setString(1, ln.getUsuario());
            cmd.setString(2, ln.getClave());
            rs = cmd.executeQuery();

            if (rs.next()) {
                retorno = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos, Credenciales incorrectas");
            }
            //cmd.close();
            //cn.close();
        } catch (SQLException e) {
            System.err.println("Error en al Ingresar " + e);
            retorno = false;
        }
        return retorno;
    }

}
