package com.banco.clases;

import static com.banco.menus.menuFormaImpresion.FormaImp;

import com.banco.clases.clasesValidar.Validar;
import com.banco.menus.menuSeleccionBanco;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Transacciones {
  @Getter @Setter private double saldo;
  @Getter @Setter private double total;
  @Getter @Setter private String nombreTransaccion;

  public Transacciones(double saldo, double total, String nombreTransaccion) {
    this.saldo = saldo;
    this.total = total;
    this.nombreTransaccion = nombreTransaccion;
  }

}
