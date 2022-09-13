package com.banco.menus;

import com.banco.clases.Cuenta;
import org.apache.log4j.Logger;

import java.util.Scanner;


public class MenuSaldoApertura {

  public Logger MenuSaldoApertura = Logger.getLogger(MenuSaldoApertura.class);

  static boolean bandera = false;
  static int saldo = 0;

  public int saldoApertura() {
    System.out.println(
            "Por favor digite el saldo con el que quiere abrir la cuenta(como minimo $25):");
    System.out.print("$");
    Scanner sc = new Scanner(System.in);
    if (sc.hasNextInt()) {
      saldo = sc.nextInt();
    } else {
      System.out.println("no se permiten cadenas de texto");
      saldoApertura();
    }
    if (saldo < 25) {
      System.out.println(
              "El valor ingresado es menor a $25,por favor ingrese un valor mayor o igual a $25");
      saldoApertura();
    }
    return saldo;
  }
}

