package interfaces;

@FunctionalInterface
public interface IRegex {
    boolean validateInput(String patter, String input);
}

