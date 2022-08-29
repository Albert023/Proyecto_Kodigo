package com.banco.clases;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Getter @Setter
    String nombre, apellido, email, telefono;

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

}
