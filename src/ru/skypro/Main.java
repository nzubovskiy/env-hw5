package ru.skypro;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String login = console.nextLine();
        String password = console.nextLine();
        String confirmPassword = console.nextLine();
        System.out.println(identification(login, password, confirmPassword));
    }

    public static String identification(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return e.getMessage();
        } catch (WrongPasswordExtension e) {
            return e.getMessage();
        }
        return login + " зарегистрирован в системе.";
    }

    public static void check(@NotNull String login, @NotNull String password, String confirmPassword) throws WrongLoginException, WrongPasswordExtension {
        if (login.length() >= 20) {
            throw new WrongLoginException("Неверный login. Превышена допустимая длина поля Login 19 символолов");
        }
        if (login.matches("[А-Я]+")) {
            throw new WrongLoginException("Неверный login. Login должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordExtension("Неверный пароль. Превышена допустимая длина пароля 19 символов");
        }
        if (password.matches("[А-Я]+")) {
            throw new WrongPasswordExtension("Неверный пароль. Пароль должен содержать только латинские буквы, цифры и знак подчеркивания");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordExtension("Пароль и подтверждение пароля не совпадают.");
        }



    }

    }



