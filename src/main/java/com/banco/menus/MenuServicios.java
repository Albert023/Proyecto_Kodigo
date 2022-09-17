package com.banco.menus;

import com.banco.clases.*;
import com.banco.clases.clasesTransaccion.PagarServicios;
import com.banco.clases.clasesTransaccion.PagarTarjeta;
import com.banco.clases.clasesValidar.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuServicios {

  private static void llamarBanco(){
    Transacciones tr = new Transacciones();
    Cuenta cu = new Cuenta();
    Banco bn = new Banco();
    Validar validar = new Validar();
    MenuSeleccionBanco mb = new MenuSeleccionBanco();
    ArrayList<String> dataBanco = new ArrayList<>();
    String nombre;
    String direccion;

    dataBanco = mb.menuBanco();
    nombre = dataBanco.get(0);
    direccion = dataBanco.get(1);
    bn.setNombreBanco(nombre);
    bn.setDireccion(direccion);
  }

  public static void menuServicios(Cuenta cuenta){

    System.out.println("Seleccione una opción\n" +
            "1. Pagar Servicios\n" +
            "2. Pagar Tarifa Tarjeta\n" +
            "3. Regresar");
    int sel = Validar.validarNumericOut();
    switch (sel){
      case 1:{
        llamarBanco();
        PagarServicios.PagoServicios(cuenta);
        break;
      }
      case 2:{
        llamarBanco();
        PagarTarjeta.PagarTarjeta(cuenta);
        break;
      }
      case 3: {
        MenuSeleccionCuenta.seleccionCuenta(new Cliente(Persona.getNombre(), Persona.getApellido(), Persona.getTelefono(), Persona.getEmail(), Persona.getDni(), Persona.getUsuario(), Persona.getClave()));
        break;
      }
      default:{
        System.out.println("Por favor digite un numero valido");
        break;
      }
    }

  }

}
