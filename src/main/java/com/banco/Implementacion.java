package com.banco;

public class Implementacion {

    public static void main(String[] args){

        Cliente cliente1 = new Cliente();
        Cuenta cuenta1 =new Cuenta(2000,cliente1);

        System.out.println(cuenta1.nombre);
         System.out.println(cuenta1.saldo);

        Transacciones transaccion = new Transacciones();

        transaccion.deposito(cuenta1);

        System.out.println(cuenta1.saldo);

    }
}
