package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.clasesValidar.Validar;

public class menuPrincipal {
    menuCrearPersona mp = new menuCrearPersona();
    MenuSaldoApertura ma = new MenuSaldoApertura();
    Cuenta cn = new Cuenta();
    private int saldo = 0;
    String tipo2;
    public void exec() {
        mp.menu();
        saldo = 2000;
        cn.ActivarCuenta();
        tipo2 = cn.corrienteCuenta();
        seleccionCuenta();
    }
    public void seleccionCuenta(){
        Cliente cliente = new Cliente(mp.nombre,mp.apellido,mp.telefono,mp.correo,mp.dni,mp.usuario,mp.clave);
        System.out.println("Seleccione una de las Opciones \n" +
                "1. Crear Cuenta \n" +
                "2. Realizar una Transacción \n" +
                "3. Salir");
        int select = Validar.validarNumeric();
        switch (select){
            case 1:{
                if (!ma.tipo1.equals("empty")){
                    System.out.println("ya a creado una cuenta, seleccione una de las siguientes opciones");
                    seleccionCuenta();
                }
                saldo = ma.saldoApertura();
                seleccionCuenta();
            }
            case 2:{
                if(ma.tipo1.equals("empty")){
                    ma.tipo1 = cn.corrienteCuenta();
                }
                Cuenta cuenta1 = new Cuenta(saldo, 34555123, ma.tipo1, cn.getEstado(),cliente);
                Cuenta cuenta2 = new Cuenta(saldo, 45555123,tipo2, cn.getEstado(),cliente);
                MenuTransacciones.menuTransaccion(cuenta1, cuenta2);
            }
            case 3:{
                System.exit(1);
            }
            default:{
             System.out.println("Por favor digite un numero valido");
             break;
            }
        }
    }
}
