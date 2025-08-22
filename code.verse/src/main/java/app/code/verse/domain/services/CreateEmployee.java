package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.HumanResourcePort;

public class CreateEmployee {
    private ValidateDataUtil validateDataUtil;
    private HumanResourcePort humanResourcesPort;

    public CreateEmployee(Employee employeeInformation) {
        validateDataUtil.validateString(employeeInformation.getName(), "nombre del empleado");
        validateDataUtil.validateString(employeeInformation.getIdNumber(),
                "número de identificación del empleado");
        validateDataUtil.validateString(employeeInformation.getEmail(), "correo electrónico del empleado");
        validateDataUtil.validateString(employeeInformation.getAddress(), "dirección del empleado");
        validateDataUtil.validateLocalDate(employeeInformation.getBirthDate(),
                "fecha de nacimiento del empleado");
        validateDataUtil.validateMaximumSize(employeeInformation.getIdNumber(),
                "número de identificación del empleado", 10);
        validateDataUtil.validateMaximumSize(employeeInformation.getEmail(), "correo electrónico del empleado",
                50);
        validateDataUtil.validateMaximumSize(employeeInformation.getAddress(), "dirección del empleado", 30);
        if (humanResourcesPort.findByIdNumber(employeeInformation.getIdNumber())) {
            throw new IllegalArgumentException("Este número de identificación ya está registrado");
        }

        humanResourcesPort.createEmployee(employeeInformation);

    }
}
