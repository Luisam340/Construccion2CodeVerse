package app.code.verse.domain.services;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.model.Patient;

public class ListPatient {
    private FindPatient findPatient;

    public Patient consult(String idNumber) {
        return findPatient.findById(idNumber);
    }
}
