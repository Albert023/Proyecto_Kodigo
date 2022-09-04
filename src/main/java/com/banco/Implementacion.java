package com.banco;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Persona;
import com.banco.menus.menuCrearPersona;

import java.util.Scanner;

import static com.banco.menus.MenuTransacciones.menuTransaccion;
import com.banco.menus.MenuSaldoApertura.*;
//import static  com.banco.menus.menuCrearPersona.*;
public class Implementacion {

  public static void main(String[] args) {

    menuCrearPersona mp = new menuCrearPersona();
    mp.exec();

  }
}
