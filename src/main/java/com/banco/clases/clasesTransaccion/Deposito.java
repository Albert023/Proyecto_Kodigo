package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.interfaces.Transaccion;
import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class Deposito implements Transaccion {

  private static Transacciones tr = new Transacciones();
  private static Banco bn = new Banco();
  private static Validar validar = new Validar();

 private void ingresoDatos(Cuenta cuenta){
   System.out.println(
           "Digite el monto a depositar " + cuenta.getNombre() + "(mayor o igual a $10):");
   System.out.print("$");
   tr.setSaldo(validar.validarSaldo());
   while (tr.getSaldo() < 10 || tr.getSaldo() > 500000) {
     System.out.println("no se permite ingresar la cantidad dada");
     tr.setSaldo(validar.validarSaldo());
   }
 }

  public void Transaccion(Cuenta cuenta){
   if(tr.getSaldo() < 10 || tr.getSaldo() > 500000){
     tr.setTotal(0);
   }else {
     tr.setTotal(cuenta.getSaldo() + tr.getSaldo());
     tr.setNombreTransaccion("Deposito");
   }
  }

  private void llamarMenuImpresion(Cuenta cuenta, Banco banco){
    Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
    FormaImp(cuenta, banco, transacciones);
  }

  public static void Deposito(Cuenta cuenta){
    Deposito pd = new Deposito();
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
    pd.ingresoDatos(cuenta);
    pd.Transaccion(cuenta);
    pd.llamarMenuImpresion(cuenta,banco);
  }
}
