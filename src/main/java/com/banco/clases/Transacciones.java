package com.banco.clases;

import com.banco.clases.clasesImpresion.imprimirCorreo;
import com.banco.clases.clasesImpresion.imprimirPdf;
import com.banco.interfaces.Imprimir;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@NoArgsConstructor
public class Transacciones {
    Imprimir generarPDF = new imprimirPdf();
    Imprimir generarCorreo = new imprimirCorreo();
    Scanner sc = new Scanner(System.in);

    private  String nombreBanco;
    private  String direccionBanco;
    double saldo;

    public void menu(){
        List<String> nombres = new ArrayList<>();
        List<String> direccion = new ArrayList<>();

        nombres.add("-----");
        nombres.add("Banco de América Central");
        nombres.add("Banco Agricola");
        nombres.add("Banco Cuscatlán de El Salvador");
        nombres.add("Banco Davivienda Salvadoreño");
        nombres.add("Banco Promérica");
        nombres.add("Banco Atlántida El Salvador");
        nombres.add("Banco ABANK");
        nombres.add("Banco Industrial El Salvador");
        nombres.add("Banco Azul de El Salvador");

        direccion.add("------");//none
        direccion.add("55 Av. Sur, entre Alameda Roosevelt y Av. Olímpica Edif. Credomatic, San Salvador, El Salvador, C.A.");//BAC
        direccion.add("Blvd. Constitución No.:100, San Salvador, El Salvador, C.A.");//Agricola
        direccion.add("Edificio Pirámide Km. 10 carretera a Santa Tecla. Depto. La Libertad.");//Cuscatlán
        direccion.add("Avenida Olímpica No.3550. San Salvador, El Salvador, C.A. Apdo. Postal No.: (0673).");//Davivienda
        direccion.add("Edificio Promérica, Centro de Estilo de Vida La Gran Vía, entre Carretera Panamericana y Calle Chiltiupán, Antiguo Cuscatlán, La Libertad.");//Promérica
        direccion.add("Blvd. Constitución y Primera Calle Poniente No. 3538 Col. Escalón, San Salvador.");//Atlantida
        direccion.add("Boulevard Merliot, Urbanización Jardines de la Hacienda, Edificio Spatium Santa Fe, Lote 4-5-6 y 7, Antiguo Cuscatlán, La Libertad.");//ABANK
        direccion.add("Avenida las Magnoleas, Boulevard el Hipódromo, No 144 Colonia, San Benito, San Salvador, C.A.");//Industrial
        direccion.add("Alameda Manuel Enrique Araujo y Avenida Olímpica No. 3553, Colonia Escalón, San Salvador.");//Azul

        Scanner na = new Scanner(System.in);
        System.out.println("Seleccione el Banco al que pertenece su cuenta : \n" +
                "1. Banco de América Central \n" +
                "2. Banco Agricola \n" +
                "3. Banco Cuscatlán de El Salvador \n" +
                "4. Banco Davivienda Salvadoreño \n" +
                "5. Banco Promérica \n" +
                "6. Banco Atlántida El Salvador \n" +
                "7. Banco ABANK \n" +
                "8. Banco Industrial El Salvador \n" +
                "9. Banco Azul de El Salvador");
        int selection = na.nextInt();
        if(selection <= 9 && selection != 0){
            nombreBanco = nombres.get(selection);
            direccionBanco = direccion.get(selection);
        }else {
            System.out.println("Seleccione una de las opciones dadas, de 1 a 9 \n" +
                    "***********************************************************\n");
            menu();
        }
    }

    public void retiro(Cuenta cuenta){

        menu();
        Banco banco = new Banco(nombreBanco,1,direccionBanco);

        System.out.println("Digite el monto a retirar " + cuenta.nombre);
        saldo = sc.nextDouble();
        cuenta.saldo = cuenta.saldo -saldo;

        generarPDF.imprimir(cuenta, banco, cuenta.saldo, "deposito");
        System.out.println("PDF Created");

        generarCorreo.imprimir(cuenta, banco, cuenta.saldo, "deposito");
        System.out.println("Correo enviado");
    }

    public void deposito(Cuenta cuenta){
        // instanciación
        menu();
        Banco banco = new Banco(nombreBanco,1,direccionBanco);
        // Datos a ingresar
        System.out.println("Digite el monto a depositar "+cuenta.nombre);
        saldo = sc.nextDouble();
        // Calculo del Deposito
        cuenta.saldo = cuenta.saldo +saldo;

        generarPDF.imprimir(cuenta, banco, cuenta.saldo, "deposito");
        System.out.println("PDF Created");

        generarCorreo.imprimir(cuenta, banco, cuenta.saldo, "deposito");
        System.out.println("Correo enviado");
    }

    public void transferencia(Cuenta cuentaTranfiere,Cuenta cuentaRecibe){
        menu();
        Banco banco = new Banco(nombreBanco,1,direccionBanco);

        System.out.println("Digite el monto a a transferir");
        saldo = sc.nextDouble();
        cuentaRecibe.saldo = cuentaRecibe.saldo +saldo;
        cuentaTranfiere.saldo = cuentaTranfiere.saldo - saldo;

        generarPDF.imprimir(cuentaTranfiere, banco, cuentaTranfiere.saldo, "deposito");
        System.out.println("PDF Created");

        generarCorreo.imprimir(cuentaTranfiere,banco,cuentaTranfiere.saldo,"deposito");
        System.out.println("Correo enviado");
    }

}
