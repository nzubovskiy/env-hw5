package ru.skypro;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message){
        super(message);
    }

}
