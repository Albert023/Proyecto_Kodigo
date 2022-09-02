package com.banco.clases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Persona {
  @Getter @Setter private int id;
  @Getter @Setter private String nombre;
  @Getter @Setter private String apellido;
  @Getter @Setter private String email;
  @Getter @Setter private String telefono;
  @Getter @Setter private String usuario;
  @Getter @Setter private String dni;
  @Getter @Setter private String clave;

  public Persona(String nombre, String apellido, String telefono, String email, String dni, String usuario,  String clave) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.email = email;
    this.dni = dni;
    this.usuario = usuario;
    this.clave = clave;
  }
}
