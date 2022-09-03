package com.banco;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Persona;
import com.banco.menus.menuCrearPersona;

import java.util.Scanner;

import static com.banco.menus.MenuTransacciones.menuTransaccion;
import static com.banco.menus.MenuSaldoApertura.saldoApertura;
//import static  com.banco.menus.menuCrearPersona.*;
public class Implementacion {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int saldo = 0;

    boolean bandera = false;

    //Persona persona1 = new Persona("Aurelio", "Capablanca", "76200295","adalberto.aguilar.paredes@gmail.com", "2344433-3",
     //       "aurel","bytlsJNUZZ");
    //Cliente cliente1 = new Cliente(persona1);

//    Persona persona1 = new Persona();
//    Cliente cliente1 = new Cliente(persona1);
//
     menuCrearPersona mp = new menuCrearPersona();
    mp.exec();
//    mp.menuPersona();
//    saldo = saldoApertura();
//
    //Cuenta cuenta1 = new Cuenta(saldo, 34555123, cliente1, persona1);
    //Cuenta cuenta2 = new Cuenta(saldo, 45555123, cliente1, persona1);
    //menuTransaccion(cuenta1,cuenta2);


    //System.out.println(cuenta1.getSaldo());
  }
}
