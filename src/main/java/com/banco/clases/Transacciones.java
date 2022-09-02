package com.banco.clases;

import com.banco.clases.clasesImpresion.imprimirConsola;
import com.banco.clases.clasesImpresion.imprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import java.util.Scanner;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Transacciones {
  Imprimir generarPDF = new imprimirPdf();
  Imprimir generarCorreo = new imprimirCorreo();
  Imprimir generarImpresionConsola = new imprimirConsola();
  Scanner sc = new Scanner(System.in);
  double saldo;
  double total;

  String nombreTransaccion;

  Banco bn = new Banco();

  public void retiro(Cuenta cuenta) {

    bn.menu();
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());

    System.out.println("Digite el monto a retirar " + cuenta.getNombre());
    saldo = sc.nextDouble();
    total = cuenta.saldo - saldo;

    nombreTransaccion = "Retiro";
    FormaImp(cuenta,banco);
  }

  public void deposito(Cuenta cuenta) {
    // instanciación
    bn.menu();
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
    // Datos a ingresar
    System.out.println("Digite el monto a depositar " + cuenta.getNombre());
    saldo = sc.nextDouble();
    // Calculo del Deposito
    total = cuenta.saldo + saldo;

    nombreTransaccion = "Deposito";
    FormaImp(cuenta,banco);

  }

  public void transferencia(Cuenta cuentaTranfiere, Cuenta cuentaRecibe) {
    bn.menu();
    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());

    System.out.println("Digite el monto a a transferir");
    saldo = sc.nextDouble();
    cuentaRecibe.saldo = cuentaRecibe.saldo + saldo;
    total = cuentaTranfiere.saldo - saldo;

    nombreTransaccion = "Transferencia";
    FormaImp(cuentaTranfiere,banco);

  }

  public void FormaImp(Cuenta cuenta, Banco banco){
    int seleccion = 0;
    boolean bandera =false;

    while (!bandera) {
      System.out.println(
              "Por favor seleccione el numero de la transaccion que desea realizar : \n"
                      + "1. Solo Generar PDF \n"
                      + "2. Enviar una copia al correo electronico \n"
                      + "3. Solo mostrar en consola ");
      seleccion = sc.nextInt();
      switch (seleccion) {
        case 1:
        {
          generarPDF.imprimir(cuenta, banco, saldo ,total, nombreTransaccion);
          System.out.println("PDF Created");
          bandera = true;
          break;
        }

        case 2:
        {
          generarCorreo.imprimir(cuenta, banco, saldo ,total, nombreTransaccion);
          System.out.println("Correo enviado");
          bandera = true;
          break;
        }

        case 3:
        {
          generarImpresionConsola.imprimir(cuenta, banco, saldo ,total, nombreTransaccion);
          bandera = true;
          break;
        }

        default:
        {
          System.out.println("Por favor digite un numero valido");
          break;
        }
      }
    }

  }


}
