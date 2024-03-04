package ru.netelogy.restspringboot;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}