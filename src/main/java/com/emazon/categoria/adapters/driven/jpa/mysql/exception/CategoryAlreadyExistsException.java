package com.emazon.categoria.adapters.driven.jpa.mysql.exception;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException() {
        super("La categoría ya existe.");
    }
}
