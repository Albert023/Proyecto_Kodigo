package com.banco;

import lombok.Getter;
import lombok.Setter;

public class Cuenta extends Cliente{
   @Setter@Getter
    double saldo;

    public Cuenta(double saldo,Cliente cliente) {
        this.saldo = saldo;
    }

    public void generarCuenta(Cliente cliente){

        System.out.println(cliente.nombre);
        setSaldo(2000);
    }


}
