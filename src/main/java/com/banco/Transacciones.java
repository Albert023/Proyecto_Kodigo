package com.banco;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.Date;
@NoArgsConstructor
public class Transacciones {

    public void retiro(Cuenta cuenta){
        double retiro;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a retirar " + cuenta.nombre);
        retiro = sc.nextDouble();
        cuenta.saldo = cuenta.saldo -retiro;
    }

    public void deposito(Cuenta cuenta){
        double deposito;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a depositar "+cuenta.nombre);
        deposito = sc.nextDouble();
        cuenta.saldo = cuenta.saldo +deposito;
        Recibo recibo = new Recibo(deposito);
        recibo.generarRecibo();
    }

    public void transferencia(Cuenta cuentaTranfiere,Cuenta cuentaRecibe){
        double saldo ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a a transferir");
        saldo = sc.nextDouble();
        cuentaRecibe.saldo = cuentaRecibe.saldo +saldo;
        cuentaTranfiere.saldo = cuentaTranfiere.saldo - saldo;
    }

}
