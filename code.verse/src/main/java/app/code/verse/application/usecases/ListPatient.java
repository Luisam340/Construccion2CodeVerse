package app.code.verse.application.usecases;

import app.code.verse.domain.model.Patient;
import app.code.verse.domain.services.FindPatient;

public class ListPatient {
    private FindPatient findPatient;

    public Patient consult(String idNumber) {
        return findPatient.findById(idNumber);
    }
}
