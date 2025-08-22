package app.code.verse.domain.model.utils;

import java.time.LocalDate;

public class ValidateDataUtil {
    public static void validateString(String field, String fieldName) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException("El campo " + fieldName + " no puede ser nulo o vacío");
        }
    }

    public static void validateLocalDate(LocalDate localDate, String fieldName) {
        if (localDate == null || localDate.isAfter(LocalDate.now().plusYears(150))) {
            throw new IllegalArgumentException("La fecha de " + fieldName + " es inválida");
        }
    }

    public static void validateMaximumSize(String field, String fieldName, int maxSize) {
        if (field.length() > maxSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener más de " + maxSize + " caracteres");
        }
    }
}

