package com.banco.clases.clasesTransaccion;

import com.banco.clases.Cliente;
import com.banco.clases.Cuenta;
import com.banco.clases.Persona;
import com.banco.clases.Transacciones;
import com.banco.clases.clasesValidar.Validar;
import com.banco.menus.MenuTransacciones;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

public class DepositoTest extends TestCase {

  @Test
  public void testTransaccionFunction(){
    Cliente cliente = new Cliente();
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2000, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    Deposito dp = new Deposito();
    tr.setSaldo(3000);
    dp.Transaccion(cuenta);

    assertEquals(5000.00, tr.getTotal() );
  }

  @Test
  public void testCorrectInput(){
    Cliente cliente = new Cliente(Persona.getNombre(),Persona.getApellido(),Persona.getTelefono(), Persona.getEmail(), Persona.getDni(), Persona.getUsuario(), Persona.getClave());
    Cuenta cn = new Cuenta();
    Cuenta cuenta = new Cuenta(2000, 34555123, cn.corrienteCuenta(), cn.getEstado(), cliente);
    Transacciones tr = new Transacciones();

    Deposito dp = new Deposito();
    tr.setSaldo(1);
    dp.Transaccion(cuenta);

    assertEquals(0.0, tr.getTotal());
  }

}