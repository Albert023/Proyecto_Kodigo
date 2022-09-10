package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.clasesValidar.Validar;
import com.banco.modelo.funcionesPersonas;
import com.banco.modelo.login;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCrearPersona {
  Validar validar = new Validar();
  Cliente pr = new Cliente();
  funcionesPersonas fp = new funcionesPersonas();
  login ln = new login();
  Scanner sc = new Scanner(System.in);
  String nombre;
  String apellido;
  String telefono;
  String correo;
  String dni;
  String usuario;
  String clave;
  String confClave;

  public void menu(){
    System.out.println("Seleccione una de las opciones \n"
            + "1. Crear usuario \n"
            + "2. Iniciar Sesion \n");
    int scan = Validar.validarNumeric();
    switch (scan){
      case 1: {
        crearpersona();
          try {
              Thread.sleep(4000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
          }
          ingresar();
        break;
      }
      case 2: {
        ingresar();
        break;
      }
      default:{
        System.out.println("Seleccione una opción valida");
        break;
      }
    }
  }

  public void ingresar(){
    System.out.println("Ingrese su usuario");
    usuario = validar.validarNombre();
    System.out.println("Ingrese su clave");
    clave = sc.next();

    pr.setUsuario(usuario);
    pr.setClave(clave);

    if (ln.Login(pr)) {
      System.out.println("Ingreso");

      ArrayList<String> results;
      pr.setUsuario(usuario);
      results = fp.consultarClientes(pr);
      nombre = results.get(0);
      apellido = results.get(1);
      telefono = results.get(2);
      correo = results.get(3);
      dni = results.get(4);
      for (int i= 0; i<results.size(); i++){
        System.out.println(results.get(i)+""+"\n");
      }
    } else {
      System.out.println("Error al Ingresar");
      ingresar();
    }
  }
  public void crearpersona() {
   Scanner sc = new Scanner(System.in);

    System.out.println("Inserte su Nombre: ");
    nombre = validar.validarNombre();

    System.out.println("Inserte su Apellido: ");
    apellido = validar.validarApellido();

    System.out.println("Inserte su Telefono: ");
    telefono = validar.validarTelefono();

    System.out.println("Inserte su Correo: ");
    correo = validar.validarCorreo();

    System.out.println("Inserte su DNI: ");
    dni = validar.validarDNI();

    System.out.println("Inserte su Usuario: ");
    usuario = sc.next();

    System.out.println("Inserte su Clave: ");
    clave = sc.next();

    System.out.println("Confirme Su Clave");
    confClave = sc.next();
    validar.validarMismaClave(clave, confClave);

    pr.setId(fp.idIncremental());
    pr.setNombre(nombre);
    pr.setApellido(apellido);
    pr.setTelefono(telefono);
    pr.setEmail(correo);
    pr.setDni(dni);
    pr.setUsuario(usuario);
    pr.setClave(clave);
    if (fp.guardarCliente(pr)) {
      System.out.println("Datos guardados");
    } else {
      System.out.println("Error al gurdar datos");
    }
  }
}