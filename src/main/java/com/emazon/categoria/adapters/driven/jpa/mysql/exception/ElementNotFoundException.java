package com.emazon.categoria.adapters.driven.jpa.mysql.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Elemento no encontrado.");
    }
}
