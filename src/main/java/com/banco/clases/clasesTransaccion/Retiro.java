package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.interfaces.Transaccion;
import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class Retiro implements Transaccion {

  private static Transacciones tr = new Transacciones();
  private static Banco bn = new Banco();
  private static Validar validar = new Validar();
  private static void ingresarDatos(Cuenta cuenta){
    System.out.println(
            "Digite el monto a retirar " + cuenta.getNombre() + "(mayor o igual a $10):");
    System.out.print("$");
    tr.setSaldo(validar.validarSaldo());
    while (tr.getSaldo() > cuenta.getSaldo() || tr.getSaldo() == cuenta.getSaldo()) {
      System.out.println("no se permite vaciar completamente la cuenta");
      tr.setSaldo(validar.validarSaldo());
    }
  }

  public void Transaccion(Cuenta cuenta){
    tr.setTotal(cuenta.getSaldo() - tr.getSaldo());
    tr.setNombreTransaccion("Retiro");
  }

  private static void llamarMenuImpresion(Cuenta cuenta,Banco banco){
    Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
    FormaImp(cuenta, banco, transacciones);
  }

  public static void Retiro(Cuenta cuenta){
     Retiro rt = new Retiro();
     Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
     rt.ingresarDatos(cuenta);
     rt.Transaccion(cuenta);
     rt.llamarMenuImpresion(cuenta, banco);
  }
}
