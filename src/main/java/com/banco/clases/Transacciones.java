package com.banco.clases;
import com.banco.clases.Cuenta;
import com.banco.clases.Recibo;
import lombok.NoArgsConstructor;
import com.banco.clases.clasesImpresion.imprimirPdf;

import java.util.Scanner;


@NoArgsConstructor
public class Transacciones extends imprimirPdf {

    public void retiro(Cuenta cuenta){
        double saldo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a retirar " + cuenta.nombre);
        saldo = sc.nextDouble();
        cuenta.saldo = cuenta.saldo -saldo;
    }

    public void deposito(Cuenta cuenta){
        double deposito;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a depositar "+cuenta.nombre);
        deposito = sc.nextDouble();
        cuenta.saldo = cuenta.saldo +deposito;
        Recibo recibo = new Recibo(deposito);
        //recibo.generarRecibo(cuenta);
        generarPDF();
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
