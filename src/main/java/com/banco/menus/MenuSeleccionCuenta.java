package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.clasesValidar.Validar;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuSeleccionCuenta {

    public static Logger MenuSeleccionCuenta = Logger.getLogger(MenuSeleccionCuenta.class);

    public void seleccionCuenta(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        Cuenta cn = new Cuenta();
        MenuSelectTipoCuenta tc = new MenuSelectTipoCuenta();
        MenuSaldoApertura ma = new MenuSaldoApertura();
        String tipo2;
        Boolean valid = false;
        int select = 0;
        tipo2 = cn.corrienteCuenta();

        //while (!valid) {
        System.out.println(tc.tipo1);
        System.out.println(ma.saldo+" || "+cn.getSaldo()+" ");

        System.out.println("Seleccione una de las Opciones \n" +
                "1. Realizar una Transacción \n" +
                "2. Salir");
        String selectString = sc.nextLine();

        valid = Validar.validarNumeric(selectString);
        if (valid == false) {
            MenuSeleccionCuenta.log(Level.WARN, "Se ingreso un caracter no numerico ");
            seleccionCuenta(cliente);
        } else {
            select = Integer.parseInt(selectString);
        }
        switch (select) {
            case 1: {
                if (tc.tipo1 == "") {
                    cn.ActivarCuenta();
                    tc.tipo1 = cn.corrienteCuenta();
                }
                if (cn.getSaldo()==0){
                    cn.setSaldo(2000);
                }
                Cuenta cuenta1 = new Cuenta(cn.getSaldo(), 34555123, tc.tipo1, cn.getEstado(), cliente);
                Cuenta cuenta2 = new Cuenta(cn.getSaldo(), 45555123, tipo2, cn.getEstado(), cliente);
                MenuTransacciones.menuTransaccion(cuenta1, cuenta2);
                break;
            }
            case 2: {
                System.exit(1);
                break;
            }
            default: {
                System.out.println("Por favor digite un numero valido\n");
                break;
            }
            //}
        }

    }
}
