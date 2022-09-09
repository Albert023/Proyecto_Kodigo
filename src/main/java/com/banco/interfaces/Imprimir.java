package com.banco.interfaces;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;

public interface Imprimir {
  void imprimir(Cuenta cuenta, Banco banco, Transacciones transaccion);
}
