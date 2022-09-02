package ui.SecondMenu;

public enum SecondMenuEnum {
    PRINTX("Print x for test"),
    GO_BACK("Go to the first menu"),
    EXIT("Exit");

    private final String value;

    SecondMenuEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
