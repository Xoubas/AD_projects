package org.example;

import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaConverter implements AttributeConverter<LocalDate, String> {
    @Override
    public String convertToDatabaseColumn(LocalDate localdate) {
        if (localdate == null) {
            return null;
        }
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localdate);
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return LocalDate.parse(dbData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
