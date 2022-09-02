package ui.SecondMenu;

import ui.AbstractMenuEnum;
import ui.demomenu.DemoMenu;

public class SecondMenu extends AbstractMenuEnum<SecondMenuEnum> {
    public SecondMenu() {
        SecondMenuEnum option = changeOption(SecondMenuEnum.class);
        manageCases(option);
    }

    public void manageCases(SecondMenuEnum result) {
        switch (result) {
            case PRINTX:
                System.out.println("X");
                new SecondMenu();
                break;
            case GO_BACK:
                new DemoMenu();
                break;
            case EXIT:
                break;
        }
    }
}

