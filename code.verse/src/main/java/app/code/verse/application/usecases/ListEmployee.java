package app.code.verse.application.usecases;

import app.code.verse.domain.model.Employee;
import app.code.verse.domain.services.FindEmployee;

public class ListEmployee {
    private FindEmployee findEmployee;

    public Employee consult(String idNumber) {
        return findEmployee.findById(idNumber);
    }
}
