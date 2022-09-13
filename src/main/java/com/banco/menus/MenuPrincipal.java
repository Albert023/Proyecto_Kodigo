package com.banco.menus;

import com.banco.clases.Cuenta;
import org.apache.log4j.Logger;

public class MenuPrincipal {
    public Logger MenuPrincipal = Logger.getLogger(MenuPrincipal.class);
    MenuCrearPersona mp = new MenuCrearPersona();
    MenuCrearCuentas cc = new MenuCrearCuentas();
    public void exec() {
        mp.menu();
        cc.crearCuenta();
    }
}
