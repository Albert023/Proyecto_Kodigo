package com.banco.clases.clasesTransaccion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.interfaces.Transaccion;
import com.banco.menus.MenuSeleccionBanco;

import java.util.ArrayList;

import static com.banco.menus.MenuFormaImpresion.FormaImp;

public class Deposito implements Transaccion {



  public void Transaccion(Cuenta cuenta){
    Transacciones tr = new Transacciones();
    Banco bn = new Banco();
    Validar validar = new Validar();

    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
    System.out.println(
            "Digite el monto a depositar " + cuenta.getNombre() + "(mayor o igual a $10):");
    System.out.print("$");
    tr.setSaldo(validar.validarSaldo());
    while (tr.getSaldo() < 10 || tr.getSaldo() > 500000) {
      System.out.println("no se permite ingresar la cantidad dada");
      tr.setSaldo(validar.validarSaldo());
    }
    tr.setTotal(cuenta.getSaldo() + tr.getSaldo());
    tr.setNombreTransaccion("Deposito");
    Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
    FormaImp(cuenta, banco, transacciones);
  }

  public static void Deposito(Cuenta cuenta){
    Deposito pd = new Deposito();
    pd.Transaccion(cuenta);
  }
}
