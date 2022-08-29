package com.banco.clases;

import com.banco.clases.clasesImpresion.imprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import lombok.NoArgsConstructor;

import java.util.Scanner;


@NoArgsConstructor
public class Transacciones {

    public void retiro(Cuenta cuenta){
        double saldo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el monto a retirar " + cuenta.nombre);
        saldo = sc.nextDouble();
        cuenta.saldo = cuenta.saldo -saldo;
    }
    //Porque no usar un solo escaner ?
    //Se repite el nombre del banco (no seria mejor tener el banco ya echo y desplegar un meno para seleccionar banco)
    public void deposito(Cuenta cuenta){
        Imprimir generarPDF =new imprimirPdf();
        Imprimir imprimir = new imprimirCorreo();

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

        generarPDF.imprimir(cuenta,banco,deposito,"deposito");
        imprimir.imprimir(cuenta,banco,deposito,"deposito");
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
