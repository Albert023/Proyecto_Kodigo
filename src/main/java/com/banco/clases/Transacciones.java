package com.banco.clases;

import com.banco.clases.clasesImpresion.imprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import java.util.Scanner;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Transacciones {
  Imprimir generarPDF = new imprimirPdf();
  Imprimir generarCorreo = new imprimirCorreo();
  Scanner sc = new Scanner(System.in);
  private String nombreBanco;
  private String direccionBanco;
  double saldo;
  Banco bn = new Banco();

  public void retiro(Cuenta cuenta) {

    bn.menu();
    Banco banco = new Banco(nombreBanco, 1, direccionBanco);

    System.out.println("Digite el monto a retirar " + cuenta.nombre);
    saldo = sc.nextDouble();
    cuenta.saldo = cuenta.saldo - saldo;

    generarPDF.imprimir(cuenta, banco, cuenta.saldo, "deposito");
    System.out.println("PDF Created");

    generarCorreo.imprimir(cuenta, banco, cuenta.saldo, "deposito");
    System.out.println("Correo enviado");
  }

  public void deposito(Cuenta cuenta) {
    // instanciación
    bn.menu();
    Banco banco = new Banco(nombreBanco, 1, direccionBanco);
    // Datos a ingresar
    System.out.println("Digite el monto a depositar " + cuenta.nombre);
    saldo = sc.nextDouble();
    // Calculo del Deposito
    cuenta.saldo = cuenta.saldo + saldo;

    generarPDF.imprimir(cuenta, banco, cuenta.saldo, "deposito");
    System.out.println("PDF Created");

    generarCorreo.imprimir(cuenta, banco, cuenta.saldo, "deposito");
    System.out.println("Correo enviado");
  }

  public void transferencia(Cuenta cuentaTranfiere, Cuenta cuentaRecibe) {
    bn.menu();
    Banco banco = new Banco(nombreBanco, 1, direccionBanco);

    System.out.println("Digite el monto a a transferir");
    saldo = sc.nextDouble();
    cuentaRecibe.saldo = cuentaRecibe.saldo + saldo;
    cuentaTranfiere.saldo = cuentaTranfiere.saldo - saldo;

    generarPDF.imprimir(cuentaTranfiere, banco, cuentaTranfiere.saldo, "deposito");
    System.out.println("PDF Created");

    generarCorreo.imprimir(cuentaTranfiere, banco, cuentaTranfiere.saldo, "deposito");
    System.out.println("Correo enviado");
  }
}
