package com.emazon.categoria.domain.model;

import com.emazon.categoria.domain.exception.EmptyFieldException;
import com.emazon.categoria.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Brand {
    private final Long id;
    private final String name;
    private final String description;

    public Brand(Long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        this.id = id;
        this.name = requireNonNull(name,DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description,DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
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
