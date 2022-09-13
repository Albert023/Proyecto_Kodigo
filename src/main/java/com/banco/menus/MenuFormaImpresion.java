package com.banco.menus;

import com.banco.clases.Banco;
import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesImpresion.imprimirConsola;
import com.banco.clases.clasesImpresion.imprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuFormaImpresion {

  public static Logger MenuFormaImpresion = Logger.getLogger(MenuFormaImpresion.class);

  public static void FormaImp(Cuenta cuenta, Banco banco, Transacciones transacciones) {
    int seleccion = 0;
    boolean bandera = false;
    Imprimir generarPDF = new imprimirPdf();
    Imprimir generarCorreo = new imprimirCorreo();
    Imprimir generarImpresionConsola = new imprimirConsola();
    MenuSeleccionCuenta mp = new MenuSeleccionCuenta();
    Cliente cliente = new Cliente();

    Scanner sc = new Scanner(System.in);

    while (!bandera) {
      System.out.println(
          "Por favor seleccione el numero de la transaccion que desea realizar : \n"
              + "1. Solo Generar PDF \n"
              + "2. Enviar una copia al correo electronico \n"
              + "3. Solo mostrar en consola ");
      System.out.println("\nDigite su opcion: ");
      if (sc.hasNextInt()) {
        seleccion = Integer.parseInt(sc.nextLine());
      } else {
        System.out.println("no se permiten cadenas de texto");
        FormaImp(cuenta, banco, transacciones);
      }
      switch (seleccion) {
        case 1:
          {
            generarPDF.imprimir(cuenta, banco, transacciones);
            System.out.println("PDF Created");
            mp.seleccionCuenta(cliente);
            bandera = true;
            break;
          }
        case 2:
          {
            generarCorreo.imprimir(cuenta, banco, transacciones);
            System.out.println("Correo enviado");
            mp.seleccionCuenta(cliente);
            bandera = true;
            break;
          }
        case 3:
          {
            generarImpresionConsola.imprimir(cuenta, banco, transacciones);
            mp.seleccionCuenta(cliente);
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

  void selectOpt(){
     System.out.println("");
  }

}
