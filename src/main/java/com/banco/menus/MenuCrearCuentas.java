package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuCrearCuentas {

  public static Logger MenuCrearCuentas = Logger.getLogger(MenuCrearCuentas.class);

   public void crearCuenta(){
   Scanner sc = new Scanner(System.in);
   MenuSaldoApertura ma = new MenuSaldoApertura();
   MenuSelectTipoCuenta tc = new MenuSelectTipoCuenta();
   MenuSeleccionCuenta mc = new MenuSeleccionCuenta();
   Cuenta cu = new Cuenta();
   Cliente cn = new Cliente();
   Cliente cliente = new Cliente(cn.getNombre(), cn.getApellido(),cn.getTelefono(), cn.getEmail(), cn.getDni(),cn.getUsuario(),cn.getClave());

   System.out.println("¿Desea Crear una Cuenta? \n" +
           "Si/No \n");
      String resp = sc.next();
     if(resp.equals("Si") || resp.equals("si") || resp.equals("SI")){
         ma.saldo = ma.saldoApertura();
         cu.setSaldo(ma.saldo);
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
