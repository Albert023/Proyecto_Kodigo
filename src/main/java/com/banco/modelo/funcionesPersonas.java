package com.banco.modelo;

import com.banco.connector.conexion;
import com.banco.clases.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class funcionesPersonas extends conexion{

    public Connection cn;

    public funcionesPersonas() {

        conexion sn = new conexion();
        cn = sn.conexion();
    }

    public boolean guardarCliente(Persona pr) {
        boolean resp = false;
        try {
            String sql = "insert into clientes (idcliente, nombrecliente, apellidocliente, telefonocliente, correocliente, dnicliente, usuariocliente, clavecliente) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, pr.getId());
            cmd.setString(2,pr.getNombre());
            cmd.setString(3,pr.getApellido());
            cmd.setString(4,pr.getTelefono());
            cmd.setString(5,pr.getEmail());
            cmd.setString(6,pr.getDni());
            cmd.setString(7,pr.getUsuario());
            cmd.setString(8,pr.getClave());

            if (!cmd.execute()) {
                resp = true;
            }
         cmd.close();
         cn.close();
        } catch (Exception e) {

            System.out.println("Error de inserción" + e.toString());
        }
        return resp;
    }

    public int idIncremental() {
        int ids = 1;
        try {
            String sql = "SELECT Max(idcliente) FROM clientes";
            PreparedStatement cmd = cn.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                ids = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ids;
    }

    public void main (String[]args){
        Persona pr = new Persona();
        funcionesPersonas fp = new funcionesPersonas();
        pr.setId(fp.idIncremental());
        pr.setNombre("Ray");
        pr.setApellido("Bradbury");
        pr.setTelefono("3455-4344");
        pr.setEmail("B@gmail.com");
        pr.setDni("234463-6");
        pr.setUsuario("ray23");
        pr.setClave("gH123456%&");
        if (fp.guardarCliente(pr)) {
            System.out.println("Datos guardados");
        } else {
            System.out.println("Error al gurdar datos");
        }
    }


}
