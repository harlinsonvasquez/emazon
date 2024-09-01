package com.emazon.categoria.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No se encontraron datos.";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "El elemento indicado no existe.";
    public static final String CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "La categoría que intenta crear ya existe.";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "El campo %s no puede estar vacío.";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "El campo %s no puede recibir valores negativos.";
}
