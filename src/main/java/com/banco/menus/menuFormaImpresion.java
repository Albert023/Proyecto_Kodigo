package com.banco.menus;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.clasesImpresion.ImprimirConsola;
import com.banco.clases.clasesImpresion.ImprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import com.banco.clases.Transacciones;
import com.banco.interfaces.ImprimirPDF;

import java.util.Scanner;

public class menuFormaImpresion {
    
    public static void FormaImp(Cuenta cuenta, Banco banco, Transacciones transacciones){
        int seleccion = 0;
        boolean bandera =false;
        ImprimirPDF generarPDF = new imprimirPdf();
        Imprimir generarCorreo = new ImprimirCorreo();
        Imprimir generarImpresionConsola = new ImprimirConsola();

        //Transacciones tr = new Transacciones();
        //Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());

        Scanner sc = new Scanner(System.in);

        while (!bandera) {
            System.out.println(
                    "Por favor seleccione el numero de la transaccion que desea realizar : \n"
                            + "1. Solo Generar PDF \n"
                            + "2. Enviar una copia al correo electronico \n"
                            + "3. Solo mostrar en consola ");
            System.out.println("\nDigite su opcion: ");
            seleccion = sc.nextInt();
            switch (seleccion) {
                case 1:

                {

                    generarPDF.imprimirPDF(cuenta, banco, transacciones);
                    System.out.println("PDF Created");
                    bandera = true;
                    break;
                }

                case 2:
                {
                    generarCorreo.imprimir(cuenta, banco, transacciones);
                    System.out.println("Correo enviado");
                    bandera = true;
                    break;
                }

                case 3:
                {
                    generarImpresionConsola.imprimir(cuenta, banco, transacciones);
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
