package com.banco.menus;

import com.banco.clases.Cuenta;

public class MenuPrincipal {
    MenuCrearPersona mp = new MenuCrearPersona();
    MenuCrearCuentas cc = new MenuCrearCuentas();
    public void exec() {
        mp.menu();
        cc.crearCuenta();
    }
}
