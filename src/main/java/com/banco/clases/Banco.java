package com.banco.clases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Banco {

  @Getter @Setter private static String nombreBanco;
  @Getter @Setter private static int identificador;
  @Getter @Setter private static String direccion;

  public Banco(String nombreBanco, int identificador, String direccion) {
    this.nombreBanco = nombreBanco;
    this.identificador = identificador;
    this.direccion = direccion;
  }
}
