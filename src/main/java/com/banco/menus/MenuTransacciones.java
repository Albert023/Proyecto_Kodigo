package com.banco.menus;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesTransaccion.Deposito;
import com.banco.clases.clasesTransaccion.Retiro;
import com.banco.clases.clasesTransaccion.Transferencia;
import com.banco.clases.clasesValidar.Validar;
import com.banco.interfaces.Transaccion;
import com.banco.modelo.funcionesTransacciones;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuTransacciones {

  public static Logger MenuTransacciones = Logger.getLogger(MenuTransacciones.class);


  public static void llamarBanco(){
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

  public static void menuTransaccion(Cuenta cuenta1) {
    llamarBanco();
    int seleccion = 0;
    boolean bandera = false;
    funcionesTransacciones ft = new funcionesTransacciones();

    while (!bandera) {
      System.out.println(
          "\nPor favor seleccione el numero de la transaccion que desea realizar : \n"
              + "1. Deposito \n"
              + "2. Retiro \n"
              + "3. Transferencia a otra cuenta ");
      System.out.println("Digite su opcion: ");
      seleccion = Validar.validarNumericOut();
      switch (seleccion) {
        case 1:
          {
            Deposito.Deposito(cuenta1);
            bandera = true;
            break;
          }
        case 2:
          {
            Retiro.Retiro(cuenta1);
            bandera = true;
            break;
          }
        case 3:
          {
            Transferencia.Transferencia(cuenta1);
            bandera = true;
            break;
          }
        default:
          {
            System.out.println("Por favor digite un numero valido");
            MenuTransacciones.log(Level.WARN, "No existe la opción seleccionada");
            break;
          }
      }
    }
  }
}
