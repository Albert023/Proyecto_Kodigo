package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.clasesValidar.Validar;
import com.google.googlejavaformat.Doc;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuSeleccionCuenta {

    public static Logger MenuSeleccionCuenta = Logger.getLogger(MenuSeleccionCuenta.class);
    static MenuSelectTipoCuenta tc = new MenuSelectTipoCuenta();
    static MenuSaldoApertura ma = new MenuSaldoApertura();
    static Cuenta cn = new Cuenta();
    private static int select;

    private static Cuenta Activarcuenta(Cliente cliente){
        if (tc.tipo1 == null) {
            cn.ActivarCuenta();
            tc.tipo1 = cn.corrienteCuenta();
        }
        if (cn.getSaldo()==0){
            cn.setSaldo(2000);
        }
        Cuenta cuenta1 = new Cuenta(cn.getSaldo(), 34555123, tc.tipo1, cn.getEstado(), cliente);
        return cuenta1;
    }

    public static void seleccionCuenta(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        Boolean valid = false;
        select = 0;
        //while (!valid) {
        System.out.println(tc.tipo1);
        System.out.println(ma.saldo+" || "+cn.getSaldo()+" ");

        System.out.println("Seleccione una de las Opciones \n" +
                "1. Realizar una Transacción \n" +
                "2. Realizar Pago de Servicios \n" +
                "3. Salir");
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
                Cuenta cuenta = Activarcuenta(cliente);
                MenuTransacciones.menuTransaccion(cuenta);
                break;
            }
            case 2: {
               Cuenta cuenta = Activarcuenta(cliente);
               MenuServicios.menuServicios(cuenta);
               break;
            }
            case 3: {
                System.exit(1);
                break;
            }
            default: {
                System.out.println("Por favor digite un numero valido\n");
                MenuSeleccionCuenta.log(Level.WARN, "No existe la opción seleccionada");
                break;
            }
            //}
        }

    }
}
