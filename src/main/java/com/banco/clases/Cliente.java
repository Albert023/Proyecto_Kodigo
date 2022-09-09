package com.banco.clases;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cliente extends Persona {

  public Cliente(String nombre, String apellido, String telefono, String correo, String dni, String usuario, String clave) {
    this.setNombre(nombre);
    this.setApellido(apellido);
    this.setTelefono(telefono);
    this.setEmail(correo);
    this.setDni(dni);
    this.setUsuario(usuario);
    this.setClave(clave);
  }
}
