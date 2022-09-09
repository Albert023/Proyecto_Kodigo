package com.banco.clases.clasesImpresion;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.interfaces.Imprimir;

public class imprimirConsola implements Imprimir {
  @Override
  public void imprimir(Cuenta cuenta, Banco banco, Transacciones transaccion) {
    // agregar codigo

    System.out.println(
        "==============================\n"
            + "            Recibo\n"
            + ""
            + cuenta.getNombre()
            + " "
            + cuenta.getApellido()
            + " | "
            + cuenta.getNumCuenta()
            + "\n\n"
            + "Monto a "
            + transaccion.getNombreTransaccion()
            + ": $"
            + transaccion.getSaldo()
            + "\n"
            + "Moto de la cuenta: $"
            + cuenta.getSaldo()
            + "\n\n"
            + "Total: $"
            + transaccion.getTotal()
            + "\n"
            + "==============================");
  }
}
