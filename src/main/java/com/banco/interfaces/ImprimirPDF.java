package com.banco.interfaces;

import com.banco.clases.Banco;
import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;

public interface ImprimirPDF {

    void imprimirPDF(Cuenta cuenta, Banco banco, Transacciones transaccion);

}
