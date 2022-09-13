package com.banco.menus;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSeleccionBanco {

  public Logger MenuSeleccionBanco = Logger.getLogger(MenuSeleccionBanco.class);
  private String nombre;
  private String direccion;
  private int selection;
  ArrayList<String> BancoE = new ArrayList<>();

  public ArrayList<String> menuBanco() {
    List<String> nombres = new ArrayList<>();
    List<String> direcciones = new ArrayList<>();

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

    direcciones.add("------"); // none
    direcciones.add(
        "55 Av. Sur, entre Alameda Roosevelt y Av. Olímpica Edif. Credomatic, San Salvador, El Salvador, C.A."); // BAC
    direcciones.add("Blvd. Constitución No.:100, San Salvador, El Salvador, C.A."); // Agricola
    direcciones.add(
        "Edificio Pirámide Km. 10 carretera a Santa Tecla. Depto. La Libertad."); // Cuscatlán
    direcciones.add(
        "Avenida Olímpica No.3550. San Salvador, El Salvador, C.A. Apdo. Postal No.: (0673)."); // Davivienda
    direcciones.add(
        "Edificio Promérica, Centro de Estilo de Vida La Gran Vía, entre Carretera Panamericana y Calle Chiltiupán, Antiguo Cuscatlán, La Libertad."); // Promérica
    direcciones.add(
        "Blvd. Constitución y Primera Calle Poniente No. 3538 Col. Escalón, San Salvador."); // Atlantida
    direcciones.add(
        "Boulevard Merliot, Urbanización Jardines de la Hacienda, Edificio Spatium Santa Fe, Lote 4-5-6 y 7, Antiguo Cuscatlán, La Libertad."); // ABANK
    direcciones.add(
        "Avenida las Magnoleas, Boulevard el Hipódromo, No 144 Colonia, San Benito, San Salvador, C.A."); // Industrial
    direcciones.add(
        "Alameda Manuel Enrique Araujo y Avenida Olímpica No. 3553, Colonia Escalón, San Salvador."); // Azul

    Scanner na = new Scanner(System.in);
    System.out.println(
        "Seleccione el Banco al que pertenece su cuenta : \n"
            + "1. Banco de América Central \n"
            + "2. Banco Agricola \n"
            + "3. Banco Cuscatlán de El Salvador \n"
            + "4. Banco Davivienda Salvadoreño \n"
            + "5. Banco Promérica \n"
            + "6. Banco Atlántida El Salvador \n"
            + "7. Banco ABANK \n"
            + "8. Banco Industrial El Salvador \n"
            + "9. Banco Azul de El Salvador");
    System.out.println("\nDigite su opcion: ");

    if (na.hasNextInt()) {
      selection = na.nextInt();
    } else {
      System.out.println("no se permiten cadenas de texto");
      MenuSeleccionBanco.log(Level.WARN, "No se permiten cadenas de texto en este menu");
      menuBanco();
    }
    if (selection <= 9 && selection != 0) {
      nombre = nombres.get(selection);
      direccion = direcciones.get(selection);
      BancoE.add(nombre);
      BancoE.add(direccion);

    } else {
      System.out.println(
          "Seleccione una de las opciones dadas, de 1 a 9 \n"
              + "***********************************************************\n");
      MenuSeleccionBanco.log(Level.WARN, "No existe la opción seleccionada");
      menuBanco();
    }
    return (BancoE);
  }
}
