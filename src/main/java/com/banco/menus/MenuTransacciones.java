package com.banco.menus;

import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;

import java.util.Scanner;

public class MenuTransacciones {


    public static void menuTransaccion(Cuenta cuenta1, Cuenta cuenta2) {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        boolean bandera = false;
        Transacciones transaccion = new Transacciones();

        while (!bandera) {
            System.out.println(
                    "\nPor favor seleccione el numero de la transaccion que desea realizar : \n"
                            + "1. Deposito \n"
                            + "2. Retiro \n"
                            + "3. Transferencia a otra cuenta ");
            System.out.println("Digite su opcion: ");
            seleccion = Integer.parseInt(sc.nextLine());
            switch (seleccion) {
                case 1: {

                    transaccion.deposito(cuenta1);
                    bandera = true;
                    break;
                }

                case 2: {

                    transaccion.retiro(cuenta1);
                    bandera = true;
                    break;
                }

                case 3: {
                    transaccion.transferencia(cuenta1, cuenta2);
                    bandera = true;
                    break;
                }

                default: {
                    System.out.println("Por favor digite un numero valido");
                    System.out.println("\nDesea volver a intentarlo: \n"
                            + "1. Si \n"
                            + "2. No\n");
                    System.out.println("Digite su opcion: ");

                    int op = Integer.parseInt(sc.nextLine());

                    switch (op) {
                        case 1: {
                            bandera = false;
                            break;
                        }

                        case 2: {
                            System.exit(0);
                        }

                        break;
                    }

                }
            }
        }
    }
}
