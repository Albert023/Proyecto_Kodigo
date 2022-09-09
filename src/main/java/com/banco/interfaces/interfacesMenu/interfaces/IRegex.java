package com.banco.interfaces.interfacesMenu.interfaces;

@FunctionalInterface
public interface IRegex {
  boolean validateInput(String patter, String input);
}
