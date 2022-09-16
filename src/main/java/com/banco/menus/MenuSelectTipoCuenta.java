package com.banco.menus;

import com.banco.clases.Cuenta;
import com.banco.clases.clasesValidar.Validar;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuSelectTipoCuenta {
    public static Logger MenuSelectTipoCuenta = Logger.getLogger(MenuSelectTipoCuenta.class);
    public static String tipo1;

    public void selectTipoCuenta(){
        Cuenta ct = new Cuenta();
        Boolean valid = false;
        int sel = 0;
        Scanner sc = new Scanner(System.in);

        while(!valid) {
            System.out.println("**********************************************\n" +
                    "**********************************************\n");
            System.out.println("Seleccione el tipo de su cuenta\n" +
                    "1. Cuenta de Ahorros \n" +
                    "2. Cuenta Corriente");
            String selString = sc.nextLine();
            valid = Validar.validarNumeric(selString);

            if (valid == false) {
                MenuSelectTipoCuenta.log(Level.WARN, "Se ingreso un caracter no numerico ");
            } else {
                sel = Integer.parseInt(selString);
            }
            switch (sel) {
                case 1: {
                    tipo1 = ct.ahorroCuenta();
                    break;
                }
                case 2: {
                    tipo1 = ct.corrienteCuenta();
                    break;
                }
                default: {
                    System.out.println("Por favor digite un numero valido");
                    MenuSelectTipoCuenta.log(Level.WARN, "No existe la opción seleccionada");
                    break;
                }
            }
        }
    }
}
