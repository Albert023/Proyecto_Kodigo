package com.banco.menus;

import com.banco.clases.Cuenta;
import com.banco.clases.clasesValidar.Validar;

import java.util.Scanner;

public class MenuSaldoApertura {

  static boolean bandera = false;
  static int saldo = 0;
  String tipo1 = "empty";
  Cuenta ct = new Cuenta();
  public int saldoApertura() {

    System.out.println(
        "Por favor digite el saldo con el que quiere abrir la cuenta(como minimo $25):");
    System.out.print("$");
    Scanner sc = new Scanner(System.in);
    if (sc.hasNextInt()) {
      saldo = sc.nextInt();
      selectTipoCuenta();
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

  public void selectTipoCuenta(){
    System.out.println("**********************************************\n" +
            "**********************************************\n");
    System.out.println("Seleccione el tipo de su cuenta\n" +
            "1. Cuenta de Ahorros \n" +
            "2. Cuenta Corriente");
    int sel = Validar.validarNumeric();
    switch (sel){
      case 1:{
        tipo1 = ct.ahorroCuenta();
        break;
      }
      case 2:{
        tipo1 = ct.corrienteCuenta();
        break;
      }
      default:{
        System.out.println("Por favor digite un numero valido");
        break;
      }
    }
  }

}
