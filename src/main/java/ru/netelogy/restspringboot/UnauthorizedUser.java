package ru.netelogy.restspringboot;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}