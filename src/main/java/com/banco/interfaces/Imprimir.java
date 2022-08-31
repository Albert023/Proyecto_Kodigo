package com.banco.interfaces;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;

public interface Imprimir {
  void imprimir(Cuenta cuenta, Banco banco, double deposito, double total,String transaccion);
}
