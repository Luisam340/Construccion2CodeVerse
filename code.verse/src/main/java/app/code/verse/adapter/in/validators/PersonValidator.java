package app.code.verse.adapter.in.validators;

import java.time.LocalDate;

public class PersonValidator extends SimpleValidator {
    public String nameValidator(String value) throws Exception {
        return stringValidator(value, "Nombre");
    }

    public String idNumberValidator(String value) throws Exception {
        return stringValidator(value, "Número de identificación");
    }

    public String userNameValidator(String value) throws Exception {
        maximumSizeValidator(value, "nombre de usuario", 15);
        return stringValidator(value, "nombre de usuario");
    }

    public String passwordValidator(String value) throws Exception {
        minimumSizeValidator(value, "contraseña", 8);
        if (!value.matches(".*[A-Z].*") || !value.matches(".*\\d.*") || !value.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException(
                    "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial");
        }
        return stringValidator(value, "contraseña");
    }

    public LocalDate birthDateValidator(LocalDate value) throws Exception {
        return localDateValidator(value, "fecha de nacimiento");
    }

    public String emailValidator(String value) throws Exception {
        emailFormatValidator(value);
        return stringValidator(value, "correo electrónico");
    }

    public String addressValidator(String value) throws Exception {
        maximumSizeValidator(value, "dirección", 30);
        return stringValidator(value, "dirección");
    }

    public String roleValidator(String value) throws Exception {
        return stringValidator(value, "rol");
    }

    public String genderValidator(String value) throws Exception {
        return stringValidator(value, "género");
    }

    public String kidnipValidator(String value) throws Exception {
        return stringValidator(value, "parentesco");
    }

    public String phoneNumberValidator(String value) throws Exception {
        return stringValidator(value, "número de teléfono");
    }

}
