package app.code.verse.domain.ports;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.Patient;

public interface HumanResourcePort {
    public void createEmployee(Employee employee);

    public void createPatient(Patient patient);

    public boolean findByIdNumber(String idNumber);
}
