package com.banco.menus;

import com.banco.clases.Persona;
import com.banco.modelo.funcionesPersonas;

import java.util.Scanner;

public class menuCrearPersona {

    Persona pr = new Persona();
    funcionesPersonas fp = new funcionesPersonas();


    public void menuPersona(){
       System.out.println("Seleccione la operación que desea realizar\n" +
               "1. Registrar\n" +
               "2. Log In");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        int select = sc.nextInt();
       if(select == 1 && select != 0){
            crearpersona();
       }else if (select == 2 && select != 0){

       } else {
           System.out.println(
                   "Seleccione una de las opciones dadas, 1 o 2 \n"
                           + "***********************************************************\n");
           menuPersona();
       }

    }

    public void crearpersona(){

        String nombre;
        String apellido;
        String telefono;
        String correo;
        String dni;
        String usuario;
        String clave;
        String confClave;

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte su Nombre: ");
        nombre = sc.next();
        System.out.println("Inserte su Apellido: ");
        apellido = sc.next();
        System.out.println("Inserte su Telefono: ");
        telefono = sc.next();
        System.out.println("Inserte su Correo: ");
        correo = sc.next();
        System.out.println("Inserte su DNI: ");
        dni = sc.next();
        System.out.println("Inserte su Usuario: ");
        usuario = sc.next();
        System.out.println("Inserte su Clave: ");
        clave = sc.next();
        System.out.println("Confirme Su Clave");
        confClave = sc.next();

        pr.setId(fp.idIncremental());
        pr.setNombre(nombre);
        pr.setApellido(apellido);
        pr.setTelefono(telefono);
        pr.setEmail(correo);
        pr.setDni(dni);
        pr.setUsuario(usuario);
        pr.setClave(clave);

       //if (nombre!=" " && apellido!=" " && telefono!=" " && correo!=" " && dni!=" " && usuario!=" " && clave!=" " && confClave!=" " && clave == confClave){
            if (fp.guardarCliente(pr)) {
                System.out.println("Datos guardados");
                Persona persona = new Persona(nombre,apellido,telefono,correo,dni,usuario,clave);
                
            } else {
                System.out.println("Error al gurdar datos");
            }
        //}else {
         //   System.out.println("");
        //}

    }
}
