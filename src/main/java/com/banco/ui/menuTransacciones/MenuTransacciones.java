package com.banco.ui.menuTransacciones;

import com.banco.clases.Cuenta;
import com.banco.clases.Transacciones;
import com.banco.ui.AbstractMenuEnum;

public class MenuTransacciones extends AbstractMenuEnum<MenuTransaccionesEnum> {
  public MenuTransacciones() {
    MenuTransaccionesEnum option = changeOption(MenuTransaccionesEnum.class);
    manageCases(option);
  }

  public void manageCases(MenuTransaccionesEnum result) {

    boolean bandera = false;
    while (!bandera) {

      switch (result) {
        case Adicion:
          Transacciones transaccion = null;
          Cuenta cuenta1 = null;
          {
            //transaccion.deposito(cuenta1);
            bandera = true;
            break;
          }

        case Retiro:
          {
            /*transaccion.retiro(cuenta1);
            bandera = true;
            break;*/
          }

        case Transferencia:
          {

            /*transaccion.transferencia(cuenta1, cuenta2);
            bandera = true;
            break;*/
          }

        default:
          {
            System.out.println("Por favor digite un numero valido");
            break;
          }
      }
    }
  }
}
