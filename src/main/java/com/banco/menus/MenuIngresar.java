package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.clasesValidar.Validar;
import com.banco.modelo.funcionesPersonas;
import com.banco.modelo.login;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuIngresar {
    public Logger MenuIngresar = Logger.getLogger(MenuIngresar.class);
    funcionesPersonas fp = new funcionesPersonas();
    MenuCrearPersona mp = new MenuCrearPersona();
    Cliente pr = new Cliente();

    public  void  ingresar(){
        Validar validar = new Validar();

        Scanner sc = new Scanner(System.in);
        login ln = new login();

        System.out.println("Ingrese su usuario");
        mp.usuario = validar.validarNombre();
        System.out.println("Ingrese su clave");
        mp.clave = sc.next();

        pr.setUsuario(mp.usuario);
        pr.setClave(mp.clave);

        if (ln.Login(pr)) {
            System.out.println("Ingreso \n");

            ArrayList<String> results;
            pr.setUsuario(mp.usuario);
            results = fp.consultarClientes(pr);
            pr.setNombre(results.get(0));
            pr.setApellido(results.get(1));
            pr.setTelefono(results.get(2));
            pr.setEmail(results.get(3));
            pr.setDni(results.get(4));

            for (String result : results) {
                System.out.println(result + "" + "\n");
            }
        } else {
            System.out.println("Error al Ingresar\n");
            MenuIngresar.log(Level.WARN, "Se ingreso un usuario invalido");
            ingresar();
        }
    }

}

