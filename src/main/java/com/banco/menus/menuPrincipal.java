package com.banco.menus;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;

public class MenuPrincipal {
    MenuCrearPersona mp = new MenuCrearPersona();
    MenuCrearCuentas cc = new MenuCrearCuentas();
    Cuenta cn = new Cuenta();
    public void exec() {
        mp.menu();
        cc.crearCuenta();
    }
}
