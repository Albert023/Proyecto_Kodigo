package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.clasesValidar.Validar;
import com.banco.modelo.funcionesPersonas;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class MenuCrearPersona {
  public static Logger MenuCrearPersonas = Logger.getLogger(MenuCrearPersona.class);
  Validar validar = new Validar();
  Cliente pr = new Cliente();
  funcionesPersonas fp = new funcionesPersonas();
  Scanner sc = new Scanner(System.in);

  private static String nombre;
  private static String apellido;
  private static String telefono;
  private static String correo;
  private static String dni;
  static String usuario;
  static String clave;
  private static String confClave;

  public void menu(){
    Boolean valid = false;
    int scan = 0;
    MenuIngresar mi = new MenuIngresar();

    //while(!valid) {
        System.out.println("Seleccione una de las opciones \n"
                + "1. Crear usuario \n"
                + "2. Iniciar Sesion \n");
        String scanString = sc.nextLine();
        valid = Validar.validarNumeric(scanString);

        if (valid == false) {
          MenuCrearPersonas.log(Level.WARN, "Se ingreso un caracter no numerico ");
        } else {
            scan = Integer.parseInt(scanString);

        }
        switch (scan) {
            case 1: {
                crearpersona();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                mi.ingresar();
                break;
            }
            case 2: {
                mi.ingresar();
                break;
            }
            default: {
                System.out.println("Seleccione una opción valida\n");
                MenuCrearPersonas.log(Level.WARN, "Se ingreso un dato no valido en este menu");
                menu();
                break;
            }
        }
    //}
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
      System.out.println("Datos guardados \n");
    } else {
      System.out.println("Error al gurdar datos \n");
      MenuCrearPersonas.log(Level.WARN, "Error en creación de usuarios");
      crearpersona();
    }
  }
}