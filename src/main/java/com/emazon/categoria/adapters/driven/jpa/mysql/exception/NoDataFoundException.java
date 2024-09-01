package com.emazon.categoria.adapters.driven.jpa.mysql.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super("No se encontraron datos.");
    }
}