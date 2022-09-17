package com.banco.clases.clasesTransaccion;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.menus.MenuSeleccionCuenta;
import junit.framework.TestCase;
import org.junit.Test;

public class PagarTarjetaTest extends TestCase {

  @Test
  public void testCorrectIncidence(){
    Cliente cliente = new Cliente();
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    PagarTarjeta pt  = new PagarTarjeta();
    pt.resp = "Si";
    pt.SaldoPagar = 1500;
    pt.Transaccion(cuenta);
    assertEquals(0.0, tr.getTotal());

  }

  @Test
  public void testCorrectResult(){
    Cliente cliente = new Cliente();
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2000, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    PagarTarjeta pt  = new PagarTarjeta();
    pt.resp = "Si";
    pt.SaldoPagar = 1500;
    pt.Transaccion(cuenta);
    assertEquals(500.0, tr.getTotal());
  }

}