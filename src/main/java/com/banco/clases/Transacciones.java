package com.banco.clases;
import com.banco.clases.Cuenta;
import com.banco.clases.Recibo;
import com.banco.clases.Banco;
import com.banco.clases.Cliente;
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
        String nombreBanco;
        String direccionBanco;
        // Datos del Banco
        // nombre
        Scanner na = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su banco");
        nombreBanco = na.next();
        //Direccion
        Scanner da = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su banco");
        direccionBanco = da.next();
        // instanciación
        Banco banco = new Banco(nombreBanco,1,direccionBanco);
        // Datos a ingresar
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a depositar "+cuenta.nombre);
        deposito = sc.nextDouble();
        // Calculo del Deposito
        cuenta.saldo = cuenta.saldo +deposito;
        Recibo recibo = new Recibo(deposito);
        //recibo.generarRecibo(cuenta);
        generarPDF(nombreBanco, cuenta.getNumCuenta(), "Deposito", cuenta.nombre , deposito );
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
