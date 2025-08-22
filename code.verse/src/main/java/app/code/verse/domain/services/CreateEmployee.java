package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;

public class CreateEmployee {
    private EmployeePort employeePort;
    private FindEmployee findEmployee;

    public void createEmployee(Employee employee) throws Exception {
        ValidateDataUtil.validateString(employee.getName(), "El nombre del empleado no puede ser nulo o vacío");
        ValidateDataUtil.validateString(employee.getIdNumber(), "EL número de identificación no puede ser nulo o vacío");
        ValidateDataUtil.validateString(employee.getEmail(), "El correo electrónico no puede ser nulo o vacío");
        ValidateDataUtil.validateString(employee.getAddress(), "La dirección no puede ser nula o vacía");
        ValidateDataUtil.validateString(employee.getUserName(), "El nombre de usuario no puede ser nulo o vacío");
        ValidateDataUtil.validateString(employee.getPassword(), "La contraseña no puede ser nula o vacía");
        ValidateDataUtil.validateString(employee.getRole(), "El rol no puede ser nulo o vacío");
        ValidateDataUtil.validateLocalDate(employee.getBirthDate(), "La fecha de nacimiento  no puede ser nula o vacía");
        ValidateDataUtil.validateMaximumSize(employee.getIdNumber(), "número de identificación", 10);
        ValidateDataUtil.validateMaximumSize(employee.getEmail(), "correo electrónico", 50);
        ValidateDataUtil.validateMaximumSize(employee.getAddress(), "dirección", 30);
        if (findEmployee.existsById(employee)) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        if (employeePort.existsByUserName(employee.getUserName())) {
            throw new Exception("Ese nombre de usuario ya está en uso");
        }
        employeePort.save(employee);
    }
}