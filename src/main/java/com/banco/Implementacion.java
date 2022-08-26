package com.banco;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;

public class Implementacion {

    public static void main(String[] args){

        Cliente cliente1 = new Cliente();
        Cuenta cuenta1 =new Cuenta(2000,cliente1);

        System.out.println(cuenta1.getNombre());
         System.out.println(cuenta1.getSaldo());

        Transacciones transaccion = new Transacciones();

        transaccion.deposito(cuenta1);

        System.out.println(cuenta1.getSaldo());

    }
}
