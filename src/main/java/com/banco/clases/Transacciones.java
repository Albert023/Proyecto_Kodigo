package com.banco.clases;

import static com.banco.menus.menuFormaImpresion.FormaImp;

import com.banco.clases.clasesValidar.Validar;
import com.banco.menus.menuSeleccionBanco;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Transacciones {
  @Getter @Setter private double saldo;

  @Getter @Setter private double total;

  @Getter @Setter private String nombreTransaccion;

  public Transacciones(double saldo, double total, String nombreTransaccion) {
    this.saldo = saldo;
    this.total = total;
    this.nombreTransaccion = nombreTransaccion;
  }

  Banco bn = new Banco();
  Validar validar = new Validar();
  menuSeleccionBanco mb = new menuSeleccionBanco();
  ArrayList<String> dataBanco = new ArrayList<>();
  private String nombre;
  private String direccion;

//  public void retiro(Cuenta cuenta) {
//    dataBanco = mb.menuBanco();
//    nombre = dataBanco.get(0);
//    direccion = dataBanco.get(1);
//    bn.setNombreBanco(nombre);
//    bn.setDireccion(direccion);
//    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
//
//    System.out.println(
//        "Digite el monto a retirar " + cuenta.getNombre() + "(mayor o igual a $10):");
//    System.out.print("$");
//    saldo = validar.validarSaldo();
//    while (saldo > cuenta.getSaldo() || saldo == cuenta.getSaldo()) {
//      System.out.println("no se permite vaciar completamente la cuenta");
//      saldo = validar.validarSaldo();
//    }
//    total = cuenta.saldo - saldo;
//
//    setSaldo(saldo);
//    setTotal(total);
//    setNombreTransaccion("Retiro");
//    Transacciones transacciones = new Transacciones(getSaldo(), getTotal(), getNombreTransaccion());
//    FormaImp(cuenta, banco, transacciones);
//  }
//
//  public void deposito(Cuenta cuenta) {
//    dataBanco = mb.menuBanco();
//    nombre = dataBanco.get(0);
//    direccion = dataBanco.get(1);
//    bn.setNombreBanco(nombre);
//    bn.setDireccion(direccion);
//    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
//    System.out.println(
//        "Digite el monto a depositar " + cuenta.getNombre() + "(mayor o igual a $10):");
//    System.out.print("$");
//    saldo = validar.validarSaldo();
//    total = cuenta.saldo + saldo;
//
//    setSaldo(saldo);
//    setTotal(total);
//    setNombreTransaccion("Deposito");
//
//    Transacciones transacciones = new Transacciones(getSaldo(), getTotal(), getNombreTransaccion());
//    FormaImp(cuenta, banco, transacciones);
//  }
//
//  public void transferencia(Cuenta cuentaTranfiere, Cuenta cuentaRecibe) {
//    dataBanco = mb.menuBanco();
//    nombre = dataBanco.get(0);
//    direccion = dataBanco.get(1);
//    bn.setNombreBanco(nombre);
//    bn.setDireccion(direccion);
//    Banco banco = new Banco(bn.getNombreBanco(), 1, bn.getDireccion());
//
//    System.out.println("Digite el monto a a transferir(mayor o igual a $10)");
//    System.out.print("$");
//    saldo = validar.validarSaldo();
//    cuentaRecibe.saldo = cuentaRecibe.saldo + saldo;
//    total = cuentaTranfiere.saldo - saldo;
//
//    setSaldo(saldo);
//    setTotal(total);
//    setNombreTransaccion("Transferencia");
//    Transacciones transacciones = new Transacciones(getSaldo(), getTotal(), getNombreTransaccion());
//    FormaImp(cuentaTranfiere, banco, transacciones);
//  }
}
