package ui.demomenu;

public enum DemoMenuEnum {
    SECOND("Go to the next menu"),
    PRINT("Print Lorem Ipsum"),
    EXIT("Exit");

    private final String value;

    DemoMenuEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
