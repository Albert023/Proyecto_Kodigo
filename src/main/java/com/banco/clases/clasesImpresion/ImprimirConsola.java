package com.banco.clases.clasesImpresion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.interfaces.Imprimir;

public class ImprimirConsola implements Imprimir {
  @Override
  public void imprimir(Cuenta cuenta, Banco banco, Transacciones transaccion) {
    // agregar codigo

    System.out.println("Recibo");
  }
}
