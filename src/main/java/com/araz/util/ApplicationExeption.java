package com.araz.util;

public class ApplicationExeption extends Exception {
    public ApplicationExeption(){}

    public ApplicationExeption(String message){
        super(message);
    }

    public ApplicationExeption(String message, Throwable e){
        super(message, e);
    }
}
