package com.banco.clases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class Persona {
  @Getter @Setter static private int id;
  @Getter @Setter static private String nombre;
  @Getter @Setter static private String apellido;
  @Getter @Setter static private String email;
  @Getter @Setter static private String telefono;
  @Getter @Setter static private String usuario;
  @Getter @Setter static private String dni;
  @Getter @Setter static private String clave;
}
