package com.banco;

import lombok.AllArgsConstructor;
import lombok.Generated;


public class Recibo {

    double saldo;

    public Recibo(double saldo) {
        this.saldo = saldo;
    }

    public void generarRecibo(){
    System.out.println("Este es el recibo");
    }

}
