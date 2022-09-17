package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.interfaces.Transaccion;
import com.banco.menus.MenuSeleccionCuenta;
import com.banco.menus.MenuServicios;
import java.util.Scanner;

import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class PagarServicios implements Transaccion {
  private static double SaldoPagar ;
  private static Transacciones tr = new Transacciones();
  private static Banco bn = new Banco();
  private static Scanner sc = new Scanner(System.in);
  private static String resp;

  private static void ingresarDatos(){
    SaldoPagar = 200.00;
    System.out.println("Su saldo a pagar es de "+" "+SaldoPagar+" $ USD");
    System.out.println("Desea Proceder con el pago\n" +
            "Si/No");
    resp = sc.next();
  }

  public void Transaccion(Cuenta cuenta){
      if(SaldoPagar > cuenta.getSaldo() || SaldoPagar == cuenta.getSaldo()){
         System.out.println("no se permite vaciar completamente la cuenta");
         MenuSeleccionCuenta.seleccionCuenta(new Cliente());
      }else{
        Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
        tr.setSaldo(SaldoPagar);
        tr.setTotal(cuenta.getSaldo() - SaldoPagar);
        tr.setNombreTransaccion("Pago Servicios");
        llamarMenuImpresion(cuenta, banco);
      }
  }

  private static void llamarMenuImpresion(Cuenta cuenta, Banco banco){
    Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
    FormaImp(cuenta, banco, transacciones);
    SaldoPagar = 0;
  }

  public static void PagoServicios(Cuenta cuenta){
    PagarServicios ps = new PagarServicios();
    ps.ingresarDatos();
    if(resp.equals("Si") || resp.equals("si") || resp.equals("SI")){
      ps.Transaccion(cuenta);
    }
    else if(resp.equals("No") || resp.equals("no") || resp.equals("NO")) {
      MenuServicios.menuServicios(cuenta);
    }
    else {
      System.out.println("Debe escribir únicamente Si o No, porfavor vuelva a intentarlo");
      PagoServicios(cuenta);
    }
  }
}
