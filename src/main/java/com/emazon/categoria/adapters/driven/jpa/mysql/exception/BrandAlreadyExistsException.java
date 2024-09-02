package com.emazon.categoria.adapters.driven.jpa.mysql.exception;

public class BrandAlreadyExistsException extends RuntimeException{
    public BrandAlreadyExistsException() {
        super("La marca ya existe.");
    }

    public BrandAlreadyExistsException(String message) {
        super(message);
    }
}
