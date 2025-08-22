package app.code.verse.domain.model.utils;

import java.time.LocalDate;

public class ValidateDataUtil {
    public static void validateString(String field, String message) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateLocalDate(LocalDate localDate, String message) {
        if (localDate == null || localDate.isAfter(LocalDate.now().plusYears(150))) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateMaximumSize(String field, String fieldName, int maxSize) {
        if (field.length() > maxSize) {
            throw new IllegalArgumentException(
                    "El campo " + fieldName + " no puede tener más de " + maxSize + " caracteres");
        }
    }
}

