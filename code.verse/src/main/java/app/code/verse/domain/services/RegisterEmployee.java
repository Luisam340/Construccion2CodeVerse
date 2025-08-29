package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.ports.PersonPort;

public class RegisterEmployee {
    private EmployeePort employeePort;
    private PersonPort personPort;

    public RegisterEmployee(EmployeePort employeePort, PersonPort personPort) {
        this.employeePort = employeePort;
        this.personPort = personPort;
    }

    public void create(Employee employee) throws Exception {
        checkIfEmployeeExists(employee);
        employeePort.save(employee);
    }

    private void checkIfEmployeeExists(Employee employee) throws Exception {
        if (personPort.existsByIdNumber(employee.getIdNumber())) {
            throw new IllegalArgumentException("El empleado ya existe");
        }
        if (personPort.existsByUserName(employee.getUserName())) {
            throw new Exception("Ese nombre de usuario ya está en uso");
        }
    }
}