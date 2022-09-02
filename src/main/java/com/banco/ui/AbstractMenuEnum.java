package com.banco.ui;

import java.util.Arrays;

public abstract class AbstractMenuEnum<T extends Enum<T>> extends AbstractMenu<T> {

    public void printAllElements(Class<T> options) {
        Arrays.stream(options.getEnumConstants()).forEach(option ->
                System.out.println(option.ordinal() + "- " + option + "."));
    }
}
