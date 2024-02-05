package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaConverter implements AttributeConverter<Categoria, String> {

    @Override
    public String convertToDatabaseColumn(Categoria attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getFirstLetters();
    }

    @Override
    public Categoria convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        String enumName = dbData.toUpperCase();
        return Categoria.valueOf(enumName);
    }
}
