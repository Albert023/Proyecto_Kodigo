package com.banco.clases;

import com.banco.clases.Cliente;
import lombok.Getter;
import lombok.Setter;

public class Cuenta extends Cliente{
   @Setter @Getter
    double saldo;

    @Setter @Getter
    private int numCuenta;


    public Cuenta(double saldo,int numCuenta,Cliente cliente) {
        this.saldo = saldo;
        this.numCuenta = numCuenta;
    }

    public void generarCuenta(Cliente cliente){

        System.out.println(cliente.nombre);
        setSaldo(2000);
    }


}
