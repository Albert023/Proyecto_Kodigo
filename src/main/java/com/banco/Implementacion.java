package com.banco;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Persona;
import com.banco.clases.Transacciones;

import java.util.Scanner;

public class Implementacion {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double saldo;
        int seleccion;
        boolean bandera=false;
        Transacciones transaccion = new Transacciones();

        Persona persona1 = new Persona("Alberto","Chinchilla","jach20232417@gmail.com","76200295");
        Cliente cliente1 = new Cliente(persona1);

        System.out.println("Por favor digite el saldo con el que quiere abrir la cuenta");
        saldo = sc.nextDouble();
        Cuenta cuenta1 =new Cuenta(saldo,34555123,cliente1,persona1);
        Cuenta cuenta2 =new Cuenta(saldo,45555123,cliente1,persona1);

        while (!bandera){
            System.out.println("Por favor seleccione el numero de la transaccion que desea realizar : \n" +
                "1. Deposito \n" +
                "2. Retiro \n" +
                "3. Transferencia a otra cuenta \n");
            seleccion = sc.nextInt();
            switch (seleccion){
            case 1 :{transaccion.deposito(cuenta1);
            bandera = true;
            break;}

            case 2: {transaccion.retiro(cuenta1);
                bandera =true;
            break;}

            case 3: {transaccion.transferencia(cuenta1,cuenta2);
            bandera = true;
            break;}

            default:{
                    System.out.println("Por favor digite un numero valido");
                    break;
                    }
            }
        }

        System.out.println(cuenta1.getSaldo());

    }
}
