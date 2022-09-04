package com.banco.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSaldoApertura {

    static boolean bandera = false;
    static Scanner sc = new Scanner(System.in);
    static  int saldo = 0;

    public static  int saldoApertura() {

        while (!bandera) {
            System.out.println("Por favor digite el saldo con el que quiere abrir la cuenta(como minimo $25):");
            System.out.print("$");
            saldo = sc.nextInt();
            if (saldo >= 25) {
                bandera = true;

            } else {
                bandera = false;
                System.out.println("El valor ingresado es menor a $25, desea volver a intentar crear la cuenta: \n"
                        + "1. Si \n"
                        + "2. No\n");
                System.out.println("\nDigite su opcion: ");
                int op = sc.nextInt();
                switch (op) {
                    case 1: {

                        bandera = false;
                        break;
                    }

                    case 2: {
                        System.exit(0);
                    }


                    default: {
                        System.out.println("Por favor digite un numero valido");
                        System.out.println("\nDesea volver a intentarlo: \n"
                                + "1. Si \n"
                                + "2. No\n");
                        System.out.println("Digite su opcion: ");

                        int op1 = Integer.parseInt(sc.nextLine());

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
        return saldo;
    }
}
