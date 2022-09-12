package com.banco.modelo;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.menus.menuSeleccionBanco;

import java.util.ArrayList;

import static com.banco.menus.menuFormaImpresion.FormaImp;

public class funcionesTransacciones {
    Transacciones tr = new Transacciones();
    Banco bn = new Banco();
    Validar validar = new Validar();
    menuSeleccionBanco mb = new menuSeleccionBanco();
    ArrayList<String> dataBanco = new ArrayList<>();
    private String nombre;
    private String direccion;
    public void retiro(Cuenta cuenta) {
        dataBanco = mb.menuBanco();
        nombre = dataBanco.get(0);
        direccion = dataBanco.get(1);
        bn.setNombreBanco(nombre);
        bn.setDireccion(direccion);
        Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());

        System.out.println(
                "Digite el monto a retirar " + cuenta.getNombre() + "(mayor o igual a $10):");
        System.out.print("$");
        tr.setSaldo(validar.validarSaldo());
        while (tr.getSaldo() > cuenta.getSaldo() || tr.getSaldo() == cuenta.getSaldo()) {
            if (tr.getSaldo() == 0){
                System.out.println("Su Cuenta esta vacía");
                //momentaneo, no solucion final
                System.exit(1);
            }
            System.out.println("no se permite vaciar completamente la cuenta");
            tr.setSaldo(validar.validarSaldo());

        }
        tr.setTotal(cuenta.getSaldo() - tr.getSaldo());
        tr.setNombreTransaccion("Retiro");
        Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
        FormaImp(cuenta, banco, transacciones);
    }
    public void deposito(Cuenta cuenta) {
        dataBanco = mb.menuBanco();
        nombre = dataBanco.get(0);
        direccion = dataBanco.get(1);
        bn.setNombreBanco(nombre);
        bn.setDireccion(direccion);
        Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
        System.out.println(
                "Digite el monto a depositar " + cuenta.getNombre() + "(mayor o igual a $10):");
        System.out.print("$");
        tr.setSaldo(validar.validarSaldo());
        tr.setTotal(cuenta.getSaldo() + tr.getSaldo());
        tr.setNombreTransaccion("Deposito");
        Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
        FormaImp(cuenta, banco, transacciones);
    }
    public void transferencia(Cuenta cuentaTranfiere, Cuenta cuentaRecibe) {
        dataBanco = mb.menuBanco();
        nombre = dataBanco.get(0);
        direccion = dataBanco.get(1);
        bn.setNombreBanco(nombre);
        bn.setDireccion(direccion);
        Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());

        System.out.println("Digite el monto a a transferir(mayor o igual a $10)");
        System.out.print("$");
        tr.setSaldo(validar.validarSaldo());
        cuentaRecibe.setSaldo(cuentaRecibe.getSaldo() + cuentaTranfiere.getSaldo());
        tr.setTotal(cuentaTranfiere.getSaldo() - cuentaRecibe.getSaldo());

        tr.setNombreTransaccion("Transferencia");
        Transacciones transacciones = new Transacciones(tr.getSaldo(), tr.getTotal(), tr.getNombreTransaccion());
        FormaImp(cuentaTranfiere, banco, transacciones);
    }
}
