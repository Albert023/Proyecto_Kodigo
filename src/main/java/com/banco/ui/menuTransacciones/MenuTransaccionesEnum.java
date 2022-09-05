package com.banco.ui.menuTransacciones;

public enum MenuTransaccionesEnum {
  Adicion("Deposito"),
  Retiro("Retiro"),
  Transferencia("Transferencia a otras cuentas");

  private final String value;

  MenuTransaccionesEnum(String value) {
    this.value = value;
  }

  public String toString() {
    return this.value;
  }
}
