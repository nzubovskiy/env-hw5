package ru.skypro;

public class WrongPasswordExtension extends Exception {
    public WrongPasswordExtension(String message) {
        super(message);
    }
}
