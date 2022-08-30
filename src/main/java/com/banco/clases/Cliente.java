package com.banco.clases;

public class Cliente extends Persona {

  public Cliente(Persona persona) {
    super(persona.nombre, persona.apellido, persona.email, persona.telefono);
  }
}
