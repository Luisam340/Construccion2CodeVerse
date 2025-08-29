package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.enums.PersonType;
import app.code.verse.domain.model.enums.Role;
import app.code.verse.domain.ports.EmployeePort;
import app.code.verse.domain.services.RegisterEmployee;

public class HumanResourcesUseCase {
    private RegisterEmployee registerEmployee;
    private EmployeePort employeePort;

    public HumanResourcesUseCase(RegisterEmployee registerEmployee, EmployeePort employeePort) {
        this.registerEmployee = registerEmployee;
        this.employeePort = employeePort;
    }

    private void create(Employee employee, String role) throws Exception {
        employee.setRole(Role.fromDescription(role).toString());
        employee.setType(PersonType.EMPLOYEE.getPersonType());
        registerEmployee.create(employee);
    }

    public Employee findById(String idNumber) {
        Employee employee = employeePort.findByIdNumber(idNumber);
        if (employee == null) {
            throw new IllegalArgumentException("Empleado no encontrado");
        }
        return employee;
    }

    public void update(Employee employee) throws Exception {
        Employee employeeData = findById(employee.getIdNumber());
        if ( employeeData != null && !employeeData.getIdNumber().equals(employee.getIdNumber())) {
            throw new Exception("Ese nombre de usuario ya está en uso por otro empleado");
        }
            employeePort.update(employee);
    }

    public void delete(Employee employee) throws Exception {
        if (employeePort.findByIdNumber(employee.getIdNumber()) != null){
            employeePort.delete(employee);
        }


    }
}