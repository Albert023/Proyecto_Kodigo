package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.interfaces.Transaccion;
import com.banco.menus.MenuServicios;
import java.util.Scanner;

import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class PagarServicios implements Transaccion {

  private static double SaldoPagar ;
  public void Transaccion(Cuenta cuenta){
    Transacciones tr = new Transacciones();
    Banco bn = new Banco();
    Scanner sc = new Scanner(System.in);
    SaldoPagar = 200.00;
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
    System.out.println("Su saldo a pagar es de "+" "+SaldoPagar+" $ USD");
    System.out.println("Desea Proceder con el pago\n" +
           "Si/No");
    String resp = sc.next();
    if(resp.equals("Si") || resp.equals("si") || resp.equals("SI")){
      tr.setSaldo(SaldoPagar);
      tr.setTotal(cuenta.getSaldo() - SaldoPagar);
      tr.setNombreTransaccion("Pago Servicios");
      Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
      FormaImp(cuenta, banco, transacciones);
      SaldoPagar = 0;
    }
    else if (resp.equals("No") || resp.equals("no") || resp.equals("NO")) {
     MenuServicios.menuServicios(cuenta);
    }
  }

  public static void PagoServicios(Cuenta cuenta){
    PagarServicios ps = new PagarServicios();
    ps.Transaccion(cuenta);
  }
}
