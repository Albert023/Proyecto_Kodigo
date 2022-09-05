package com.banco.clases;

import lombok.Getter;
import lombok.Setter;

public class Cuenta extends Cliente {
  @Setter @Getter double saldo;

  @Setter @Getter private int numCuenta;

  public Cuenta(double saldo, int numCuenta, Cliente cliente, Persona persona) {
    super(persona);
    this.saldo = saldo;
    this.numCuenta = numCuenta;
  }
}
