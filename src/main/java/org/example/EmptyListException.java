package org.example;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("Список оказался пустым!");
    }
}
