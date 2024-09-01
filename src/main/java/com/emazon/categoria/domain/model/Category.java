package com.emazon.categoria.domain.model;

import com.emazon.categoria.domain.exception.EmptyFieldException;
import com.emazon.categoria.domain.util.DomainConstants;

public class Category {
    private final Long id;
    private final String name;
    private final String description;

    public Category(Long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
