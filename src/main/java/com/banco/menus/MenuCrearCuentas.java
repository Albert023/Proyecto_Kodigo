package com.banco.menus;

import com.banco.clases.Cliente;

import java.util.Scanner;

public class MenuCrearCuentas {

   public void crearCuenta(){
   Scanner sc = new Scanner(System.in);
   MenuSaldoApertura ma = new MenuSaldoApertura();
   MenuSelectTipoCuenta tc = new MenuSelectTipoCuenta();
   MenuSeleccionCuenta mc = new MenuSeleccionCuenta();
   MenuCrearPersona mp = new MenuCrearPersona();
   Cliente cliente = new Cliente(mp.nombre, mp.apellido, mp.telefono, mp.correo, mp.dni, mp.usuario, mp.clave);

   System.out.println("¿Desea Crear una Cuenta? \n" +
           "Si/No \n");
      String resp = sc.next();
     if(resp.equals("Si") || resp.equals("si") || resp.equals("SI")){
         ma.saldo = ma.saldoApertura();
         tc.selectTipoCuenta();
         mc.seleccionCuenta(cliente);
      } else if (resp.equals("No") || resp.equals("no") || resp.equals("NO")) {
         mc.seleccionCuenta(cliente);
     }else {
        System.out.println("Debe escribir únicamente Si o No, porfavor vuelva a intentarlo");
        crearCuenta();
     }
   }

}
