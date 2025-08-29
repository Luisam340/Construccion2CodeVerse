package app.code.verse.adapter.in.validators;

import java.time.LocalDate;

public class PolicyValidator extends SimpleValidator {

    public String policyNameValidator(String value) throws Exception {
        return stringValidator(value, "Nombre");
    }

    public String policyNumberValidator(String value) throws Exception {
        return stringValidator(value, "Número de póliza");
    }

    public LocalDate policyDateValidator(LocalDate value) throws Exception {
        return localDateValidator(value, "fecha de póliza");
    }

}