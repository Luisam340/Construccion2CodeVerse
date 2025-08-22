package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.utils.ValidateDataUtil;
import app.code.verse.domain.ports.EmployeePort;

public class UpdateEmployee {
    private EmployeePort employeePort;
    private FindEmployee findEmployee;

    public void update(Employee employee) throws Exception {
        if (findEmployee.existsById(employee)){
            ValidateDataUtil.validateString(employee.getName(), "El nombre del empleado no puede ser nulo o vacío");
            ValidateDataUtil.validateString(employee.getEmail(), "El correo electrónico no puede ser nulo o vacío");
            ValidateDataUtil.validateString(employee.getAddress(), "La dirección no puede ser nula o vacía");
            ValidateDataUtil.validateString(employee.getUserName(), "El nombre de usuario no puede ser nulo o vacío");
            ValidateDataUtil.validateString(employee.getPassword(), "La contraseña no puede ser nula o vacía");
            ValidateDataUtil.validateString(employee.getRole(), "El rol no puede ser nulo o vacío");
            ValidateDataUtil.validateLocalDate(employee.getBirthDate(), "La fecha de nacimiento  no puede ser nula o vacía");
            ValidateDataUtil.validateMaximumSize(employee.getEmail(), "correo electrónico", 50);
            ValidateDataUtil.validateMaximumSize(employee.getAddress(), "dirección", 30);
            if (employeePort.existsByUserName(employee.getUserName()) && !findEmployee.existsById(employee)) {
                throw new Exception("Ese nombre de usuario ya está en uso por otro empleado");
            }
            employeePort.update(employee);
        }


    }
}
