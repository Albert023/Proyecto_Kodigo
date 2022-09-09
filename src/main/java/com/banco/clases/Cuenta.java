package com.banco.clases;

import com.banco.clases.enums.estadoCuenta;
import com.banco.clases.enums.tipoCuenta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Cuenta extends Cliente {
  @Setter @Getter double saldo;
  @Setter @Getter private int numCuenta;
  @Setter @Getter private String tipo;
  @Setter @Getter private String estado;

  public void ActivarCuenta() {setEstado(String.valueOf(estadoCuenta.ACTIVA));}
  public void desactivarCuenta() {setEstado(String.valueOf(estadoCuenta.INACTIVA));}
  public String ahorroCuenta() {setTipo(String.valueOf(tipoCuenta.AHORROS)); return tipo;}
  public String corrienteCuenta() {setTipo(String.valueOf(tipoCuenta.CORRIENTE)); return tipo;}

  public Cuenta(double saldo, int numCuenta, String tipo, String estado ,Cliente cliente) {
    super(cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(),cliente.getEmail(), cliente.getDni(), cliente.getUsuario(), cliente.getClave());
    this.saldo = saldo;
    this.numCuenta = numCuenta;
    this.tipo = tipo;
    this.estado = estado;
  }
}
