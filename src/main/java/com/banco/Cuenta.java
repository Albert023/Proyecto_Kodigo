package com.banco;

import lombok.Getter;
import lombok.Setter;

public class Cuenta {
   @Setter@Getter
    double saldo;

    public void generarCuenta(Cliente cliente){

        System.out.println(cliente.nombre);
        setSaldo(2000);
    }


}
