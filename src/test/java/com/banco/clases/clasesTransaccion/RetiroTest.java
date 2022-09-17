package com.banco.clases.clasesTransaccion;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import junit.framework.TestCase;
import org.junit.Test;

public class RetiroTest extends TestCase {

  @Test
  public void testNonNegative(){
    Cliente cliente = new Cliente();
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2000, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    tr.setSaldo(2001);
    Retiro rt = new Retiro();
    rt.Transaccion(cuenta);

    assertEquals(0.0,tr.getTotal());
  }

  @Test
  public void testLessTransacction(){
    Cliente cliente = new Cliente();
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2000, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    tr.setSaldo(453);
    Retiro rt = new Retiro();
    rt.Transaccion(cuenta);

    assertEquals(1547.0,tr.getTotal());
  }

}