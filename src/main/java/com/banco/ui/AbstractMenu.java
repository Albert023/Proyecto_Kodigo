package com.banco.ui;

import com.banco.interfaces.interfacesMenu.interfaces.IManage;
import com.banco.interfaces.interfacesMenu.interfaces.IRegex;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractMenu<T extends Enum<T>> implements IManage<T> {
    public static final Date clock = new Date();
    protected final static IRegex regex = ((pattern, input) -> {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        return m.matches();
    });

    public abstract void printAllElements(Class<T> options);

    @Override
    public T changeOption(Class<T> options) {
        T newTag = manageOptions(options);
        return newTag;
    }

    @Override
    public T manageOptions(Class<T> options) {

        printAllElements(options);

        Scanner sc = new Scanner(System.in);
        String chosenOption = String.valueOf(sc.nextInt());

        System.out.println("Chosen option: " + Integer.parseInt(chosenOption));

        String pattern = "[0-9]";
        if (!regex.validateInput(pattern, chosenOption)) {
            System.out.println("No natural number entered in Menu options");
            return manageOptions(options);
        }
        try {
            return options.getEnumConstants()[Integer.parseInt(chosenOption)];
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        System.out.println("Number entered is not between given options");
        return manageOptions(options);
    }
}
