package com.banco.clases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Transacciones {
  @Getter @Setter private static double saldo;
  @Getter @Setter private static double total;
  @Getter @Setter private static String nombreTransaccion;

  public Transacciones(double saldo, double total, String nombreTransaccion) {
    this.saldo = saldo;
    this.total = total;
    this.nombreTransaccion = nombreTransaccion;
  }

}
