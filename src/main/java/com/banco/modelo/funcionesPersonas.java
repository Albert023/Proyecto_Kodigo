package com.banco.modelo;

import com.banco.clases.Cliente;
import com.banco.connector.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class funcionesPersonas extends conexion {

  public Connection cn;

  public funcionesPersonas() {

    conexion sn = new conexion();
    cn = sn.conexion();
  }

  public boolean guardarCliente(Cliente pr) {
    boolean resp = false;
    try {
      String sql =
          "insert into clientes (idcliente, nombrecliente, apellidocliente, telefonocliente, correocliente, dnicliente, usuariocliente, clavecliente) VALUES(?,?,?,?,?,?,?,?)";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setInt(1, pr.getId());
      cmd.setString(2, pr.getNombre());
      cmd.setString(3, pr.getApellido());
      cmd.setString(4, pr.getTelefono());
      cmd.setString(5, pr.getEmail());
      cmd.setString(6, pr.getDni());
      cmd.setString(7, pr.getUsuario());
      cmd.setString(8, pr.getClave());

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

  public ArrayList<String> consultarClientes(Cliente pr) {
    ArrayList<String> cliente = new ArrayList<>();
    boolean resp = false;
    try {
      String sql = "select nombreCliente, apellidoCliente, telefonoCliente, correoCliente, dniCliente \n" +
              "from clientes\n" +
              "where usuarioCliente = ?";
      PreparedStatement cmd = cn.prepareStatement(sql);
      String[] filas = new String[5];
      cmd.setString(1, pr.getUsuario());
      ResultSet rs = cmd.executeQuery();
      if (rs.next()) {
        for (int i = 0; i < 5; i++) {
          filas[i] = rs.getString(i + 1);
          cliente.add(filas[i]);
        }
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    }

    return (cliente);
  }
}
