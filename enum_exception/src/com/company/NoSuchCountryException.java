package com.company;

public class NoSuchCountryException extends Exception {
    public NoSuchCountryException(String inputName) {
        super(inputName + "не найден");
    }
}
