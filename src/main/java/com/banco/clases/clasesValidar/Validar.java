package com.banco.clases.clasesValidar;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validar {
    Scanner sc = new Scanner(System.in);
    public String validarNombre() {
      String nombre;
      Pattern pattern = Pattern.compile("[a-zA-ZñÑáÁéÉíÍóÓúÚ\\s]*");
      while (!sc.hasNext(pattern)) {
          System.out.println("Digite un nombre valido");
          sc.next();
      }
      nombre = sc.next();
      return nombre;
  }

    public  String validarApellido(){
      Pattern pattern = Pattern.compile("[a-zA-ZñÑáÁéÉíÍóÓúÚ\\s]*");
      String apellido;
      while (!sc.hasNext(pattern)) {
          System.out.println("Digite un apellido valido");
          sc.next();
      }
      apellido = sc.next();
      return apellido;
    }


    public  String validarTelefono(){
      Pattern pattern = Pattern.compile("[2,6,7]{1}[0-9]{3}[-][0-9]{4}");
      String telefono;
      while (!sc.hasNext(pattern)) {
          System.out.println("Digite un numero de telefono valido");
          sc.next();
      }
      telefono = sc.next();
      return telefono;
    }
    public String validarDNI(){
        Pattern pattern = Pattern.compile("[0-9]{8}[-][0-9]{1}");
        String DNI;
        while (!sc.hasNext(pattern)) {
            System.out.println("Digite un DNI valido");
            sc.next();
        }
        DNI = sc.next();
        return DNI;
    }

    public  String validarCorreo(){
        Pattern pattern = Pattern.compile("[A-Za-z0-9+_.-]+@(.+)");
        String correo;
        while (!sc.hasNext(pattern)) {
            System.out.println("Digite un correo valido");
            sc.next();
        }
        correo = sc.next();
        return correo;
    }


    public void validarMismaClave(String clave, String clave2){

        while (!clave.equals(clave2)){
        System.out.println("Las claves no coinciden por favor digite la clave nuevamente");
        clave2 = sc.next();
        }
    }
    public double validarSaldo(){
        double saldo;
        while (!sc.hasNextDouble()){
      System.out.println("Por favor digite un saldo valido\n$");
      sc.next();
        }
        saldo = sc.nextDouble();
        return saldo;
    }
}
