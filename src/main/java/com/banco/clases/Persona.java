package com.banco.clases;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Getter @Setter
    String nombre;
    @Getter @Setter
    String apellido;
    @Getter @Setter
    String email;
    @Getter @Setter
    String telefono;

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

}
