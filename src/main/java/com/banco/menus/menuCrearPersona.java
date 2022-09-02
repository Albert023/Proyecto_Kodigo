package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Persona;
import com.banco.modelo.funcionesPersonas;

import java.util.Scanner;

import static com.banco.menus.MenuSaldoApertura.saldoApertura;
import static com.banco.menus.MenuTransacciones.menuTransaccion;

public class menuCrearPersona {

    Persona pr = new Persona();
    funcionesPersonas fp = new funcionesPersonas();

    String nombre;
    String apellido;
    String telefono;
    String correo;
    String dni;
    String usuario;
    String clave;
    String confClave;


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
        //}else {
         //   System.out.println("");
        //}

    }

    public  void exec (){

        int saldo = 0;

        crearpersona();
        if (fp.guardarCliente(pr)) {
            System.out.println("Datos guardados");
            Persona persona1 = new Persona(nombre,apellido,telefono,correo,dni,usuario,clave);
            Cliente cliente1 = new Cliente(persona1);
            
            saldo = saldoApertura();

            Cuenta cuenta1 = new Cuenta(saldo, 34555123, cliente1, persona1);
            Cuenta cuenta2 = new Cuenta(saldo, 45555123, cliente1, persona1);
            menuTransaccion(cuenta1,cuenta2);
            System.out.println(cuenta1.getSaldo());

        } else {
            System.out.println("Error al gurdar datos");
        }

    }

}
