package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.interfaces.Transaccion;
import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class Transferencia implements Transaccion {

   public void Transaccion(Cuenta cuenta){
    Transacciones tr = new Transacciones();
    Banco bn = new Banco();
    Validar validar = new Validar();
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
    double transferir = 0 ;

    System.out.println("Digite el monto a Transferir "+cuenta.getNombre()+" (mayor o igual a $10)");
    System.out.print("$");
    tr.setSaldo(validar.validarSaldo());
    while (tr.getSaldo() > cuenta.getSaldo() || tr.getSaldo() == cuenta.getSaldo()) {
      System.out.println("no se permite vaciar completamente la cuenta");
      tr.setSaldo(validar.validarSaldo());
    }
    transferir = cuenta.getSaldo() - tr.getSaldo();
    //transferir - 2000
    tr.setTotal(transferir);
    tr.setNombreTransaccion("Transferencia");
    Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
    FormaImp(cuenta, banco, transacciones);
  }

  public static void Transferencia(Cuenta cuenta){
     Transferencia tr = new Transferencia();
     tr.Transaccion(cuenta);
  }
}
