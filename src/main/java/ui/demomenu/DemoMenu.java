package ui.demomenu;

import ui.AbstractMenuEnum;
import ui.SecondMenu.SecondMenu;

public class DemoMenu extends AbstractMenuEnum<DemoMenuEnum> {
        public DemoMenu() {
            DemoMenuEnum option = changeOption(DemoMenuEnum.class);
            manageCases(option);
        }

        public void manageCases(DemoMenuEnum result) {
            switch (result) {
                case SECOND:
                    new SecondMenu();
                    break;
                case PRINT:
                    System.out.println("Lorem ipsum dolor sit amet");
                    new DemoMenu();
                    break;
                case EXIT:
                    break;
            }
        }
    }

