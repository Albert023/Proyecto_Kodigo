package com.banco.clases;

public class Cliente extends Persona {

  public Cliente(Persona persona) {
    super(persona.getNombre(), persona.getApellido(), persona.getTelefono(), persona.getEmail(),   persona.getDni(), persona.getUsuario(), persona.getClave());
  }

}
