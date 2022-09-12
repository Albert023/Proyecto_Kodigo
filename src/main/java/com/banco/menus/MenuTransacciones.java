package com.banco.menus;

import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.modelo.funcionesTransacciones;

import java.util.Scanner;

public class MenuTransacciones {
  public static void menuTransaccion(Cuenta cuenta1, Cuenta cuenta2) {
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
            ft.deposito(cuenta1);
            bandera = true;
            break;
          }
        case 2:
          {
            ft.retiro(cuenta1);
            bandera = true;
            break;
          }
        case 3:
          {
            ft.transferencia(cuenta1,cuenta2);
            bandera = true;
            break;
          }
        default:
          {
            System.out.println("Por favor digite un numero valido");
            break;
          }
      }
    }
  }
}
