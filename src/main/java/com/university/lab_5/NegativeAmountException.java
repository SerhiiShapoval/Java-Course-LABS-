package com.university.lab_5;

public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
        super();
    }

    public NegativeAmountException(String message) {
        super(message);
    }
}
